package org.la.dodgers.baseball.services.impl;

 
import org.la.dodgers.baseball.dao.UserRepository;
import org.la.dodgers.baseball.domain.User;
import org.la.dodgers.baseball.services.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long user_id) {
        return null;
    }

    @Override
    public User pushUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(User updatedUser, Long user_id) {
    	 return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUserById(Long user_id) {
    	   userRepository.deleteById(user_id);
    }
}
