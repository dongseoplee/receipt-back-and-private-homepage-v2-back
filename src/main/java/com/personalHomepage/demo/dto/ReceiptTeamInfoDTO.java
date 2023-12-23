package com.personalHomepage.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ReceiptTeamInfoDTO {
    private Long team_id;
    private Long total;
    private Long amount;

    public ReceiptTeamInfoDTO(Long team_id, Long total, Long amount) {
        this.team_id = team_id;
        this.total = total;
        this.amount = amount;
    }

}
