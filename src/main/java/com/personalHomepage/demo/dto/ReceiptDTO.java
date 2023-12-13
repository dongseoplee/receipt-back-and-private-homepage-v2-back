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
    private String json_data;

    public ReceiptDTO(String image, Long team_id, String json_data) {
//        this.id = id;
        this.image = image;
        this.team_id = team_id;
        this.json_data = json_data;

    }
}
