package com.personalHomepage.demo.service;

import com.personalHomepage.demo.domain.Teams;
import com.personalHomepage.demo.dto.TeamDTO;
import com.personalHomepage.demo.repository.TeamsRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamsRepository teamsRepository;

    public TeamService(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    public void saveTeam(TeamDTO teamDTO) {
        Teams teams = new Teams();
        teams.setTeamName(teamDTO.getTeam_name());
        teams.setDescription(teamDTO.getDescription());
        teamsRepository.save(teams);
    }
    public boolean checkTeamNameDuplicate(String team_name) {
        return teamsRepository.existsByTeamName(team_name);
    }


}
