package org.la.dodgers.baseball.services;

import java.util.List;

import org.la.dodgers.baseball.dao.TeamDAO;
import org.la.dodgers.baseball.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamServiceImpl implements TeamService {

	private TeamDAO teamDAO;
	
	@Autowired
	public TeamServiceImpl(TeamDAO theteamDAO) {
		teamDAO = theteamDAO;
	}
	
	@Override
	@Transactional
	public List<Team> getAllTeams() { 
		return teamDAO.getAllTeams();
	}

	@Override
	@Transactional
	public Team getTeamById(int id) {
		return teamDAO.getTeamById(id);
	}

	

	@Override
	@Transactional
	public void saveTeam(Team team) {
		  teamDAO.saveTeam(team);
	}

	 
}






