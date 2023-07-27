package com.personalHomepage.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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



}
