package com.personalHomepage.demo.repository;

import com.personalHomepage.demo.domain.ReceiptAmountTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceiptAmountTeamRepository extends JpaRepository<ReceiptAmountTeam, Long> {

    @Query(value = "SELECT MONTH(purchased_at) AS month, SUM(amount) AS amount FROM rm_receipt_image WHERE team_id = :teamId AND purchased_at >= DATE_SUB(CURRENT_DATE(), INTERVAL 6 MONTH) GROUP BY MONTH(purchased_at)", nativeQuery = true)
    List<ReceiptAmountTeam> amountTeamFindAll(@Param("teamId") Long teamId);
}
