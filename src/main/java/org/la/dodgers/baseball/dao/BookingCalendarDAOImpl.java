package org.la.dodgers.baseball.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.la.dodgers.baseball.domain.BookingCalendar;
import org.la.dodgers.baseball.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingCalendarDAOImpl implements BookingCalendarDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public BookingCalendarDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<BookingCalendar> getAllBookings() {
		try {
			Query theQuery = entityManager.createQuery("from BookingCalendar", BookingCalendar.class);
			System.out.println("################# userdaoimpl.getallusers ");
			@SuppressWarnings("unchecked")
			List<BookingCalendar> bookingslist = theQuery.getResultList();
			System.out.println("################# userdaoimpl.getallusers ");
			return bookingslist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BookingCalendar getById(int id) {

		BookingCalendar bcs = entityManager.find(BookingCalendar.class, id);
		return bcs;
	}

	@Override
	public void book(BookingCalendar bc) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(bc); 

	}

	@Override
	public void cancel(BookingCalendar bc) {

		Query theQuery = entityManager.createQuery("delete from BookingCalendar  where id=:id");

		theQuery.setParameter("id", bc.getId());

		theQuery.executeUpdate();
	}

}
