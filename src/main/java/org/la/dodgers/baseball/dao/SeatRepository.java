package org.la.dodgers.baseball.dao;

 
import org.la.dodgers.baseball.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
