package org.la.dodgers.baseball.dao;

import java.util.List;

import org.la.dodgers.baseball.domain.User;

public interface UserDAO {

	public List<User> getAllusers();

	public User getuserById(int id);

	public void save(User theuser);

	public void deleteById(int id);
	
}
