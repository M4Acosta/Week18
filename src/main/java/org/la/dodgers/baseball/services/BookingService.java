package org.la.dodgers.baseball.services;

 

import java.util.List;

import org.la.dodgers.baseball.domain.Booking;

public interface BookingService {
    List<Booking> getAllBookings();

    Booking getBookingById(Long booking_id);

    Booking pushBooking(Booking newBooking);

    Booking updateBooking(Booking updatedBooking, Long booking_id);

    void deleteBookingById(Long booking_id);
}

