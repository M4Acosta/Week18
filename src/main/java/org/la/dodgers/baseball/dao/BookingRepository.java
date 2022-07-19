package org.la.dodgers.baseball.dao;

 
import org.la.dodgers.baseball.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
