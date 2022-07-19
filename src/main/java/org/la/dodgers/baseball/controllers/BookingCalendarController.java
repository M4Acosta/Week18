package org.la.dodgers.baseball.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.la.dodgers.baseball.domain.BookingCalendar;
import org.la.dodgers.baseball.domain.User;
import org.la.dodgers.baseball.exception.UserNotFoundException;
import org.la.dodgers.baseball.services.BookingCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/bookingcalendar")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of bookings done by user.")
public class BookingCalendarController {

	private BookingCalendarService bcService;
	
	@Autowired
	public BookingCalendarController(BookingCalendarService theuserService) {
		bcService = theuserService;
	}
	
	// Endpoint for GET /v2/bookingcalendar -- Get All bookings
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("${bookingcalendarcontroller.getallusers}")
    public List<BookingCalendar> getAllBookings() {
        return bcService.getAllBookings();
    }
  

    // Endpoint for POST /v2/bookingcalendar -- Create a new booking
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("${bookingcalendarcontroller.book}")
    public BookingCalendar createbooking(@ApiParam("booking information for a new booking to be created.")
                                   @RequestBody BookingCalendar bc) {
    	
    	// Also just in case they pass an id in JSON ... set id to 0, this is to force a save of new item ... instead of update.
    	bc.setId(0);
        bcService.book(bc);
        return bc;
    }
    
    // Endpoint for POST /v2/bookingcalendar -- deletes a booking
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation("${bookingcalendarcontroller.cancel}")
    public BookingCalendar cancelbooking(@ApiParam("cancels the booking.")
                                   @RequestBody BookingCalendar bc) {
    	
    	// Also just in case they pass an id in JSON ... set id to 0, this is to force a save of new item ... instead of update.
    	bc.setId(0);
        bcService.cancel(bc);
        return bc;
    }
     
}
