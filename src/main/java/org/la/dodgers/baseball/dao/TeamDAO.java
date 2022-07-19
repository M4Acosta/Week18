package org.la.dodgers.baseball.dao;

import java.util.List;

import org.la.dodgers.baseball.domain.Team;

public interface TeamDAO {

	public List<Team> getAllTeams();

	public Team getTeamById(int id);

	public void saveTeam(Team theuser);

	public void deleteById(int id);
	
}
