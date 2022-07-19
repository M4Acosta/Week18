package org.la.dodgers.baseball.dao;

import java.util.List;

import org.la.dodgers.baseball.domain.BookingCalendar;
import org.la.dodgers.baseball.domain.User;

public interface BookingCalendarDAO {

	public List<BookingCalendar> getAllBookings();

	public void book(BookingCalendar bc);

	public void cancel(BookingCalendar bc);

	public BookingCalendar getById(int id);
	
}
