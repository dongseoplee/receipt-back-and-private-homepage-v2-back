package com.personalHomepage.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.N;

import java.util.Date;

@Entity
@Table(name = "RM_TEAM_INFO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private Long leaderId;
    private Date establishedDate;
    private String description;
}
