package org.la.dodgers.baseball.services.impl;

 
import org.la.dodgers.baseball.dao.SeatBookedRepository;
import org.la.dodgers.baseball.domain.SeatBooked;
import org.la.dodgers.baseball.services.SeatBookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SeatBookedServiceImpl implements SeatBookedService {
    private SeatBookedRepository seatBookedRepository;

    @Autowired
    public SeatBookedServiceImpl(SeatBookedRepository seatBookedRepository) {
        this.seatBookedRepository = seatBookedRepository;
    }

    @Override
    public List<SeatBooked> getAllSeatBooked() {
        return seatBookedRepository.findAll();
    }

    @Override
    public SeatBooked getSeatBookedById(Long seat_booked_id) {
        return null;
    }

    @Override
    public SeatBooked pushSeatBooked(SeatBooked newSeatBooked) {
        return null;
    }

    @Override
    public SeatBooked updateSeatBooked(SeatBooked updatedSeatBooked, Long seat_booked_id) {
        return null;
    }

    @Override
    public void deleteSeatBookedById(Long seat_booked_id) {

    }
}
