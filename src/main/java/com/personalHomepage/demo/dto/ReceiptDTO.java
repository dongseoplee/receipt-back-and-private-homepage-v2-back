package com.personalHomepage.demo.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
@Builder
public class ReceiptDTO {

//    private Long id;
    private String image;
    private Long team_id;
    private String json_data;

    private Long amount;
    private String category;
    private Date purchasedAt;
    private String vendor;


    public ReceiptDTO(String image, Long team_id, String json_data, Long amount, String category, Date purchasedAt, String vendor) {
//        this.id = id;
        this.image = image;
        this.team_id = team_id;
        this.json_data = json_data;
        this.amount = amount;
        this.category =  category;
        this.purchasedAt = purchasedAt;
        this.vendor = vendor;

    }
}
