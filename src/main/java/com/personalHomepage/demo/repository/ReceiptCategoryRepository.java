package com.personalHomepage.demo.repository;

import com.personalHomepage.demo.domain.ReceiptCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptCategoryRepository extends JpaRepository<ReceiptCategory, Long> {
}
