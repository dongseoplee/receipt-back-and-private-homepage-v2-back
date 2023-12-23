package com.personalHomepage.demo.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "RM_RECEIPT_IMAGE")
//DB에 테이블을 먼저 만들어두지 않아도 된다. 소문자 rm_receipt_image 테이블 자동으로 생상됨
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private Long team_id;
    private String json_data;
    private Long amount;
    private String category;
    private Date purchasedAt;
    private String vendor;
}
