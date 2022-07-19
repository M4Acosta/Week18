package org.la.dodgers.baseball.dao;

 
import org.la.dodgers.baseball.domain.SeatBooked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatBookedRepository extends JpaRepository<SeatBooked, Long> {
}
