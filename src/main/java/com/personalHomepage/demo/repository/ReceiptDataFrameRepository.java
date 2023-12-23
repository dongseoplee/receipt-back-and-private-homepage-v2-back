package com.personalHomepage.demo.repository;

import com.personalHomepage.demo.domain.ReceiptDataFrameTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceiptDataFrameRepository extends JpaRepository<ReceiptDataFrameTeam, Long> {
    @Query(value = "select distinct id, team_id, amount, vendor, purchased_at, category from rm_receipt_image where team_id = :teamId GROUP BY image", nativeQuery = true)
    List<ReceiptDataFrameTeam> dateFrameFindAll(@Param("teamId") Long teamId);


}

