package org.la.dodgers.baseball.controllers;

 
import org.la.dodgers.baseball.domain.Booking;
import org.la.dodgers.baseball.domain.Booking;
import org.la.dodgers.baseball.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@RestController

@RequestMapping("/v2/bookings")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of bookings.")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

     
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    
    
    @RequestMapping(method = RequestMethod.POST, path = "/", produces = "application/json")
    @ApiOperation(value = "Creates new booking in the system")
    public ResponseEntity<Booking> createBooking(@ApiParam("create new event.")
    								@RequestBody Booking booking) {
    	Booking booking1 = bookingService.pushBooking(booking);
        return ResponseEntity.status(HttpStatus.OK).body(booking1);
    }

    
    @RequestMapping(method = RequestMethod.PUT, path = "/", produces = "application/json")
    @ApiOperation(value = "updates existing  booking in the system")
    public ResponseEntity<Booking> updateBooking(@ApiParam("update new booking.")
    								@RequestBody Booking booking) {
    	Booking b1 = bookingService.updateBooking(booking, booking.getId());
        return ResponseEntity.status(HttpStatus.OK).body(b1);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/{bbevent_id}", produces = "application/json")
    @ApiOperation(value = "deletes the booking  for a sent id")
    public ResponseEntity<?> deleteBooking(@PathVariable Long bbevent_id) {
    	bookingService.deleteBookingById(bbevent_id);
        return ResponseEntity.noContent().build();
    }
    
    
}
