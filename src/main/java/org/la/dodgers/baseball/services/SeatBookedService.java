package org.la.dodgers.baseball.services;

 

import java.util.List;

import org.la.dodgers.baseball.domain.SeatBooked;

public interface SeatBookedService {
    List<SeatBooked> getAllSeatBooked();

    SeatBooked getSeatBookedById(Long seat_booked_id);

    SeatBooked pushSeatBooked(SeatBooked newSeatBooked);

    SeatBooked updateSeatBooked(SeatBooked updatedSeatBooked, Long seat_booked_id);

    void deleteSeatBookedById(Long seat_booked_id);
}
