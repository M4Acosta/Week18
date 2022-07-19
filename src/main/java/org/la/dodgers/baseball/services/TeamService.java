package org.la.dodgers.baseball.services;

import java.util.List;

import org.la.dodgers.baseball.domain.Team;
import org.la.dodgers.baseball.domain.User;

public interface TeamService {

	List<Team> getAllTeams();

	Team getTeamById(int id); 
	
	
	void saveTeam(Team team); 

}
