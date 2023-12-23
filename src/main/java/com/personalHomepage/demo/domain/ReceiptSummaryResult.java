package com.personalHomepage.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReceiptSummaryResult {

    Long total;
    Long today;
    List<ReceiptSummary> teams;
    List<ReceiptCategory> category;

}
