package com.personalHomepage.demo.repository;

import com.personalHomepage.demo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
//    @Query("SELECT u FROM user_info u where number = :number")
    public List<UserInfo> findAllByNumber(Long number);
}
