package com.personalHomepage.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptCategoryTeam {

    @Id
    private Long total_amount;
    private String category_name;
}
