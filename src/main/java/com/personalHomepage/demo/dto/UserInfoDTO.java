package com.personalHomepage.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class UserInfoDTO {

    private Long number;

    private String user_name;
    private String university;
    private String dept;
    private String birthday;
    private String location;
    private String email_address;
    private String phone_number;
    private String git_url;
    private String skill;
    private String job;
    private String project1_url;
    private String project1_info;
    private String project2_url;
    private String project2_info;
    private String project3_url;
    private String project3_info;
    private String project4_url;
    private String project4_info;
    private String project5_url;
    private String project5_info;

    public UserInfoDTO(Long number, String user_name, String university, String dept, String birthday, String location, String email_address, String phone_number, String git_url, String skill, String job, String project1_url, String project1_info, String project2_url, String project2_info, String project3_url, String project3_info, String project4_url, String project4_info, String project5_url, String project5_info) {
        this.number = number;
        this.user_name = user_name;
        this.university = university;
        this.dept = dept;
        this.birthday = birthday;
        this.location = location;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.git_url = git_url;
        this.skill = skill;
        this.job = job;
        this.project1_url = project1_url;
        this.project1_info = project1_info;
        this.project2_url = project2_url;
        this.project2_info = project2_info;
        this.project3_url = project3_url;
        this.project3_info = project3_info;
        this.project4_url = project4_url;
        this.project4_info = project4_info;
        this.project5_url = project5_url;
        this.project5_info = project5_info;
    }
}
