package com.personalHomepage.demo.repository;

import com.personalHomepage.demo.domain.Receipt;
import com.personalHomepage.demo.domain.ReceiptCategory;
import com.personalHomepage.demo.domain.ReceiptCategoryTeam;
import com.personalHomepage.demo.dto.ReceiptCategoryDTO;
import com.personalHomepage.demo.dto.ReceiptCategoryTeamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    @Query(value = "SELECT COUNT(*) FROM rm_receipt_image WHERE YEAR(purchased_at) = YEAR(CURRENT_DATE()) AND MONTH(purchased_at) = MONTH(CURRENT_DATE())", nativeQuery = true)
    Long countNumOfThisMonthAllReceipt();

    @Query(value = "SELECT COUNT(*) FROM rm_receipt_image WHERE YEAR(createdAt) = YEAR(CURRENT_DATE()) AND MONTH(createdAt) = MONTH(CURRENT_DATE()) AND DAY(createdAt) = DAY(CURRENT_DATE())", nativeQuery = true)
    Long countNumOfAllTodayReceiptToday();

    @Query(value = "SELECT category AS categoryName, SUM(amount) AS totalAmount FROM rm_receipt_image GROUP BY category", nativeQuery = true)
    List<ReceiptCategoryDTO> categoryFindAll();

    @Query(value = "SELECT COUNT(*) FROM rm_receipt_image WHERE team_id = :teamId AND YEAR(purchased_at) = YEAR(CURRENT_DATE()) AND MONTH(purchased_at) = MONTH(CURRENT_DATE())", nativeQuery = true)
    Long countNumOfThisMonthAllReceiptTeam(@Param("teamId") Long teamId);

    @Query(value = "SELECT SUM(amount) AS amount FROM rm_receipt_image WHERE team_id = :teamId AND YEAR(purchased_at) = YEAR(CURRENT_DATE()) AND MONTH(purchased_at) = MONTH(CURRENT_DATE())", nativeQuery = true)
    Long countNumOfThisMonthAllReceiptAmountTeam(@Param("teamId") Long teamId);


}
