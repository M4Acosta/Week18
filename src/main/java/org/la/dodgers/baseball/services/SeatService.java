package org.la.dodgers.baseball.services;

 

import java.util.List;

import org.la.dodgers.baseball.domain.Seat;

public interface SeatService {
    List<Seat> getAllSeats();

    Seat getSeatById(Long seat_id);

    Seat pushSeat(Seat newSeat);

    Seat updateSeat(Seat updatedSeat, Long seat_id);

    void deleteSeatById(Long seat_id);
}
