package com.personalHomepage.demo.repository;

import com.personalHomepage.demo.domain.Receipt;
import com.personalHomepage.demo.domain.ReceiptCategoryTeam;
import com.personalHomepage.demo.dto.ReceiptCategoryTeamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceiptCategoryTeamRepository extends JpaRepository<ReceiptCategoryTeam, Long> {
    @Query(value = "SELECT category AS category_name, SUM(amount) AS total_amount FROM rm_receipt_image WHERE team_id = :teamId AND YEAR(purchased_at) = YEAR(CURRENT_DATE()) AND MONTH(purchased_at) = MONTH(CURRENT_DATE()) GROUP BY category", nativeQuery = true)
    List<ReceiptCategoryTeam> categoryTeamFindAll(@Param("teamId") Long teamId);
}
