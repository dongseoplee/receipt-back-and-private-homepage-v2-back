package com.personalHomepage.demo.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class SaveImageService {

    public void saveImage(String base64ImageData) {
        //경로설정 1.이미지 저장, 2.ocr 키 경로, 3. 이미지 불러오기
//        String outputFilePath = "src/main/resources/static/images/image.jpg";
        String outputFilePath = "/home/ubuntu/receiptImage/image.jpg";
        try {
            // Base64 디코딩
            byte[] decodedBytes = Base64.getDecoder().decode(base64ImageData);

            // 디코딩된 바이트 배열을 파일로 저장
            try (FileOutputStream fos = new FileOutputStream(new File(outputFilePath))) {
                fos.write(decodedBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
