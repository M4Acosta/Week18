package org.la.dodgers.baseball.dao;

 
import org.la.dodgers.baseball.domain.BaseBallEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseBallEventRepository extends JpaRepository<BaseBallEvent, Long> {
}
