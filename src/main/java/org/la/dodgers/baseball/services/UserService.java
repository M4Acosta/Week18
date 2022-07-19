package org.la.dodgers.baseball.services;

 

import java.util.List;

import org.la.dodgers.baseball.domain.User;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long user_id);

    User pushUser(User newUser);

    User updateUser(User updatedUser, Long user_id);

    void deleteUserById(Long user_id);
}
