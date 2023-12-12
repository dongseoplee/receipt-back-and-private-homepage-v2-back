package com.personalHomepage.demo.controller;


import com.personalHomepage.demo.dto.ReceiptDTO;
import com.personalHomepage.demo.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequiredArgsConstructor
public class ReceiptController {
    private final ReceiptService receiptService;

    @PostMapping("/receipt/image")
    public String receiptPost(ReceiptDTO receiptDTO) {
//        System.out.println(receiptDTO);
        receiptService.saveReceipt(receiptDTO);
        return "success";
    }

    @GetMapping("/receipt/info")
    public String receiptInfo() {
        return "hi";
    }
}
