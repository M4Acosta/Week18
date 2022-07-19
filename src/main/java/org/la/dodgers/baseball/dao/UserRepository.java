package org.la.dodgers.baseball.dao;

 
import org.la.dodgers.baseball.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
