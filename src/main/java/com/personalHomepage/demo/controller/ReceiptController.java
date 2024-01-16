package com.personalHomepage.demo.controller;


import com.personalHomepage.demo.domain.*;
import com.personalHomepage.demo.dto.ReceiptCategoryTeamDTO;
import com.personalHomepage.demo.dto.ReceiptDTO;
import com.personalHomepage.demo.dto.TeamDTO;
import com.personalHomepage.demo.repository.*;
import com.personalHomepage.demo.service.GoogleVisionService;
import com.personalHomepage.demo.service.ReceiptService;
import com.personalHomepage.demo.service.SaveImageService;
import com.personalHomepage.demo.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    private final TeamsRepository teamsRepository;
    private final TeamService teamService;

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

    //팀 정보 CRUD
    //1. Create, Post
    @PostMapping("teams/create")
    public String createTeam(@RequestBody TeamDTO teamDTO) {
        // 이미 존재하는 팀 이름인지 확인
        // 존재하지 않는 팀이라면 저장
        if (teamService.checkTeamNameDuplicate(teamDTO.getTeam_name())) {
            return "False";
        }
        else {
            teamService.saveTeam(teamDTO);
            return "success";
        }
    }

    //2. Read, Get
    @GetMapping("teams/info")
    public List<Teams> getTeamInfo() {
        return teamsRepository.findAll();
    }

    //3. Update, put
    @PutMapping("teams/{team_id}")
    public String teamPut(@PathVariable("team_id") Long team_id, @RequestBody TeamDTO teamDTO) {
        Optional<Teams> optionalTeams = teamsRepository.findById(team_id);
        Teams teams = optionalTeams.get();
        teams.setTeamName(teamDTO.getTeam_name());
        teams.setDescription(teamDTO.getDescription());

        teamsRepository.save(teams);
        return "success";
    }

    //4. Delete, delete
    @DeleteMapping("teams/{team_id}")
    public String teamDelete(@PathVariable("team_id") Long team_id) {
        teamsRepository.deleteById(team_id);
        return "success";
    }
}
