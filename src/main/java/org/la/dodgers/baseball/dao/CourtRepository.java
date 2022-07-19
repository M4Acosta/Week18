package org.la.dodgers.baseball.dao;

 
import org.la.dodgers.baseball.domain.Court;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {
}
