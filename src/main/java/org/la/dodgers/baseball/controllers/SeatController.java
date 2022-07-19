package org.la.dodgers.baseball.controllers;

 
import org.la.dodgers.baseball.domain.Seat;
import org.la.dodgers.baseball.domain.Seat;
import org.la.dodgers.baseball.services.SeatService;
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


@RequestMapping("/v2/seats")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of seats  .")

public class SeatController {
    private SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public List<Seat> getAllSeats() {
        return this.seatService.getAllSeats();
    }
    
    
    
    @RequestMapping(method = RequestMethod.POST, path = "/", produces = "application/json")
    @ApiOperation(value = "Creates new seat in the system")
    public ResponseEntity<Seat> createseat(@ApiParam("create new seat.")
    								@RequestBody Seat seat) {
    	Seat seat1 = seatService.pushSeat(seat);
        return ResponseEntity.status(HttpStatus.OK).body(seat1);
    }

    
    @RequestMapping(method = RequestMethod.PUT, path = "/", produces = "application/json")
    @ApiOperation(value = "updates existing  seat in the system")
    public ResponseEntity<Seat> updateseat(@ApiParam("update new seat.")
    								@RequestBody Seat seat) {
    	Seat b1 = seatService.updateSeat(seat, new Long(seat.getId()));
        return ResponseEntity.status(HttpStatus.OK).body(b1);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/{seatid}", produces = "application/json")
    @ApiOperation(value = "deletes the seat  for a sent id")
    public ResponseEntity<?> deleteseat(@PathVariable Long seatid) {
    	seatService.deleteSeatById(seatid);
        return ResponseEntity.noContent().build();
    }
}
