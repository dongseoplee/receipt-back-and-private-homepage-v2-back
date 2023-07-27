package com.personalHomepage.demo.service;

import com.personalHomepage.demo.domain.UserInfo;
import com.personalHomepage.demo.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public List<UserInfo> getUserInfoByNumber(Long number) {
        return userInfoRepository.findAllByNumber(number);
    }
}
