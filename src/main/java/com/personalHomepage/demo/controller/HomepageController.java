package com.personalHomepage.demo.controller;

import com.personalHomepage.demo.domain.UserInfo;
import com.personalHomepage.demo.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequiredArgsConstructor
public class HomepageController {

    private final UserInfoService userInfoService;

    @GetMapping("/homepage/{id}")
    public List<UserInfo> userInfoGetNumber(@PathVariable("id") Long number) {
        return userInfoService.getUserInfoByNumber(number);
        //http://localhost:8080/homepage/1
    }

    @GetMapping("/")
    public String defaultURI() {
        return "github action success! -2023.08.04, Final CI/CD test-";
    }
}
