package com.personalHomepage.demo.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ReceiptDTO {

//    private Long id;
    private String image;
    private Long team_id;

    public ReceiptDTO(String image, Long team_id) {
//        this.id = id;
        this.image = image;
        this.team_id = team_id;

    }
}
