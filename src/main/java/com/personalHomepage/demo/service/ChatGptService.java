package com.personalHomepage.demo.service;

import com.personalHomepage.demo.dto.ReceiptDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ChatGptService {
    @Value("${openai-api-key}")
    private String openaiKey;
    private final ReceiptService receiptService;

    public ChatGptService(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    public void detectResult(String ocr_result, ReceiptDTO receiptDTO) throws IOException {
        //gpt api 실행

        String url = "https://api.openai.com/v1/chat/completions";

        String questionFormat = "위 영수증에서 지출금액(숫자만)이랑 결제일자(YYYY-MM-DD)랑 지출카테고리를 식비 또는 쇼핑 또는 도서 또는 기타 중 하나로 선택해 출력해줘";
        String replace_ocr_result = ocr_result.replace("\n", " ");
        String question = " " + replace_ocr_result + " " + questionFormat;
//        System.out.println("question: " + question);
        String jsonBody = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": " + "\"" + question + "\"" + "}]}";
        // 개행 삭제
//        System.out.println("jsonBody" + jsonBody);
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + openaiKey);
        connection.setDoOutput(true);

        // Write the request body
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Read the response
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            // Handle the response
            String jsonResponse = response.toString();

            //DTO에 json 데이터 추가
            receiptDTO.setJson_data(jsonResponse);
//            System.out.println("receiptDTO" + receiptDTO);
            // 여기서 jpa 사용해서 데이터 저장
            receiptService.saveReceipt(receiptDTO);
//            System.out.println(jsonResponse);

        }  finally {
            connection.disconnect();
        }

    }
}
