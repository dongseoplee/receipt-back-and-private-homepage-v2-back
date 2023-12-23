package com.personalHomepage.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDataFrameTeam {
    @Id
    private Long id;
    private Long team_id;
    private Long amount;
    private String vendor;
    private Date purchased_at;
    private String category;
}
