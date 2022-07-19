package org.la.dodgers.baseball.services;

import java.util.List;

import org.la.dodgers.baseball.domain.BookingCalendar; 

public interface BookingCalendarService {

	List<BookingCalendar> getAllBookings();

	void book(BookingCalendar bc);

	void cancel(BookingCalendar bc);

}
