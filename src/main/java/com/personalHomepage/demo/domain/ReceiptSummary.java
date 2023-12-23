package com.personalHomepage.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Getter
@Setter
@Table(name="team_amount_summary")
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptSummary {

    @Id
    private Long teamId;

    private Long thisMonthAmount;
    private Long lastMonthAmount;

}
