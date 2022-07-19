package org.la.dodgers.baseball.controllers;

 
import org.la.dodgers.baseball.domain.Court;
import org.la.dodgers.baseball.domain.User;
import org.la.dodgers.baseball.services.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@RestController
@RequestMapping("/v2/courts")
@Api(description = "Set of endpoints for controlling stadium.")
public class CourtController {
    private CourtService courtService;

    @Autowired
    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

     
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public List<Court> getAllCourts() {
        return courtService.getAllCourts();
    }
    
    
    @RequestMapping(method = RequestMethod.POST,   produces = "application/json")
	@ApiOperation("${usercontroller.createuser}")
	public Court createCourt(@ApiParam("create a court.") @RequestBody Court court) {
	 
		// Also just in case they pass an id in JSON ... set id to 0, this is to force a
		// save of new item ... instead of update.

		courtService.pushCourt(court);
		return court;
	}
}
