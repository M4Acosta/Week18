package org.la.dodgers.baseball.controllers;

 
import org.la.dodgers.baseball.domain.SeatBooked;
import org.la.dodgers.baseball.services.SeatBookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import java.util.List;

@RestController

@RequestMapping("/v2/seatbooked")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of seat bookings.")

public class SeatBookedController {
    private SeatBookedService seatBookedService;

    @Autowired
    public SeatBookedController(SeatBookedService seatBookedService) {
        this.seatBookedService = seatBookedService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public List<SeatBooked> getAllSeatBooked() {
        return seatBookedService.getAllSeatBooked();
    }
}
