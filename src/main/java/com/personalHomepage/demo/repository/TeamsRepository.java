package com.personalHomepage.demo.repository;

import com.personalHomepage.demo.domain.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {

    boolean existsByTeamName(String team_name);

}
