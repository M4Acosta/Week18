package org.la.dodgers.baseball.services;

import java.util.List;

import org.la.dodgers.baseball.dao.BookingCalendarDAO; 
import org.la.dodgers.baseball.domain.BookingCalendar;
import org.la.dodgers.baseball.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingCalendarServiceImpl implements BookingCalendarService {

	private BookingCalendarDAO bcDAO;

	@Autowired
	public BookingCalendarServiceImpl(BookingCalendarDAO thebcDAO) {
		bcDAO = thebcDAO;
	}

	@Override
	@Transactional
	public List<BookingCalendar> getAllBookings() {
		System.out.println("###  get all users #### ");
		return bcDAO.getAllBookings();
	}

	@Override
	@Transactional
	public void book(BookingCalendar bc) {
		bcDAO.book(bc);
	}

	@Override
	@Transactional
	public void cancel(BookingCalendar bc) {
		bcDAO.cancel(bc);
	}

}
