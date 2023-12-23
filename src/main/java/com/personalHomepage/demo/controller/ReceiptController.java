package com.personalHomepage.demo.controller;


import com.personalHomepage.demo.domain.*;
import com.personalHomepage.demo.dto.ReceiptCategoryTeamDTO;
import com.personalHomepage.demo.dto.ReceiptDTO;
import com.personalHomepage.demo.repository.*;
import com.personalHomepage.demo.service.GoogleVisionService;
import com.personalHomepage.demo.service.ReceiptService;
import com.personalHomepage.demo.service.SaveImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ReceiptController {
    private final ReceiptService receiptService;
    private final GoogleVisionService googleVisionService;
    private final SaveImageService saveImageService;

    private final ReceiptSummaryRepository receiptSummaryRepository;
    private final ReceiptRepository receiptRepository;
    private final ReceiptCategoryRepository receiptCategoryRepository;
    private final ReceiptCategoryTeamRepository receiptCategoryTeamRepository;
    private final ReceiptAmountTeamRepository receiptAmountTeamRepository;
    private final ReceiptDataFrameRepository receiptDataFrameRepository;

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

//    @GetMapping("/amount/team/all")
//    public List<Receipt> getReceipt() {
//        List<Receipt> receipts = receiptService.getReceipt();
//        return convertToDTO(receipts);
//
//    }

    @GetMapping("/amount/summary")
    public ReceiptSummaryResult getSummary() {
        ReceiptSummaryResult receiptSummaryResult = new ReceiptSummaryResult();
        receiptSummaryResult.setTotal(receiptRepository.countNumOfThisMonthAllReceipt());
        receiptSummaryResult.setToday(receiptRepository.countNumOfAllTodayReceiptToday());
        receiptSummaryResult.setTeams(receiptSummaryRepository.findAll());
        receiptSummaryResult.setCategory(receiptCategoryRepository.findAll());
        return receiptSummaryResult;
    }

    @GetMapping("/info/{teamId}")
    public ReceiptTeamResult getTeamSummary(@PathVariable("teamId") Long number) {
        ReceiptTeamResult receiptTeamResult = new ReceiptTeamResult();
        receiptTeamResult.setTeamId(number);
        receiptTeamResult.setTotal(receiptRepository.countNumOfThisMonthAllReceiptTeam(number));
        receiptTeamResult.setAmount(receiptRepository.countNumOfThisMonthAllReceiptAmountTeam(number));

        return receiptTeamResult;
    }

    @GetMapping("/category/{teamId}")
    public List<ReceiptCategoryTeam> getCategoryTeam(@PathVariable("teamId") Long number) {

        return receiptCategoryTeamRepository.categoryTeamFindAll(number);
    }

    @GetMapping("amount/{teamId}")
    public List<ReceiptAmountTeam> getAmountTeam(@PathVariable("teamId") Long number) {
        return receiptAmountTeamRepository.amountTeamFindAll(number);
    }

    @GetMapping("dataframe/{teamId}")
    public List<ReceiptDataFrameTeam> getDataFrameTeam(@PathVariable("teamId") Long number) {
        return receiptDataFrameRepository.dateFrameFindAll(number);
    }

}
