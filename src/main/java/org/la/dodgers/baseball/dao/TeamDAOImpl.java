package org.la.dodgers.baseball.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.la.dodgers.baseball.domain.Team;
import org.la.dodgers.baseball.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDAOImpl implements TeamDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public TeamDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Team> getAllTeams() {
		try {
			Query theQuery = entityManager.createQuery("from Team", Team.class);
			@SuppressWarnings("unchecked")
			List<Team> teamslist = theQuery.getResultList();
			return teamslist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Team getTeamById(int id) {

		Team team = entityManager.find(Team.class, id);
		return team;
	}

	@Override
	public void saveTeam(Team team) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save employee
		currentSession.saveOrUpdate(team);

	}

	@Override
	public void deleteById(int id) {

		Query theQuery = entityManager.createQuery("delete from Team where id=:teamId");

		theQuery.setParameter("teamId", id);

		theQuery.executeUpdate();
	}

}
