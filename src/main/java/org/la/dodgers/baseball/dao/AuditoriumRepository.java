package org.la.dodgers.baseball.dao;

 
import org.la.dodgers.baseball.domain.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}
