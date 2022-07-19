package org.la.dodgers.baseball.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.la.dodgers.baseball.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public UserDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<User> getAllusers() {
		try {
		Query theQuery = entityManager.createQuery("from User", User.class);
		System.out.println("################# userdaoimpl.getallusers ");
		@SuppressWarnings("unchecked")
		List<User> userslist = theQuery.getResultList();
		System.out.println("################# userdaoimpl.getallusers ");
		return userslist;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getuserById(int id) {
		
		User employee = entityManager.find(User.class, id);
		return employee;
	}

	@Override
	public void save(User theuser) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theuser);

	}

	@Override
	public void deleteById(int id) {
		
		Query theQuery = entityManager.createQuery("delete from user where id=:employeeId");
		
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
	}

}
