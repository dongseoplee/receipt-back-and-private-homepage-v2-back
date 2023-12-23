package com.personalHomepage.demo.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ReceiptCategoryTeamDTO {
    private Long total_amount;
    private String category_name;


    public ReceiptCategoryTeamDTO(Long total_amount, String category_name) {
        this.total_amount = total_amount;
        this.category_name = category_name;
    }
}
