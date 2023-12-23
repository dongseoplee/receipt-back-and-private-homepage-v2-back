package com.personalHomepage.demo.domain;

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
@Table(name="category_amount")
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptCategory {

    @Id
    private Long total_amount;
    private String category_name;


}
