package com.personalHomepage.demo.controller;


import com.personalHomepage.demo.dto.ReceiptDTO;
import com.personalHomepage.demo.service.GoogleVisionService;
import com.personalHomepage.demo.service.ReceiptService;
import com.personalHomepage.demo.service.SaveImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequiredArgsConstructor
public class ReceiptController {
    private final ReceiptService receiptService;
    private final GoogleVisionService googleVisionService;
    private final SaveImageService saveImageService;

    @PostMapping("/receipt/image")
    public String receiptPost(@RequestBody ReceiptDTO receiptDTO) throws IOException {
//        System.out.println(receiptDTO.getImage());
        //이미지 저장
        saveImageService.saveImage(receiptDTO.getImage());
        googleVisionService.detectText(receiptDTO);
//        receiptService.saveReceipt(receiptDTO);
        return "success";
    }

    @GetMapping("/receipt/info")
    public String receiptInfo() {
        return "hi";
    }
//    @GetMapping("/extractTextFromImage")
//    public void extract() {
//        try {
//            googleVisionService.detectText();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
