package org.la.dodgers.baseball.controllers;

import lombok.extern.slf4j.Slf4j;

import org.la.dodgers.baseball.domain.BaseBallEvent;
import org.la.dodgers.baseball.domain.Game;
import org.la.dodgers.baseball.domain.Team;
import org.la.dodgers.baseball.services.BaseBallEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v2/baseballevent")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of baseball events.")
public class BaseBallEventController {
    private BaseBallEventService bbEvent;

    @Autowired
    public BaseBallEventController(BaseBallEventService bbEvent) {
        this.bbEvent = bbEvent;
    }

    
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    @ApiOperation(value = "Returns list Base ball events/tournaments registered in the system")
    public ResponseEntity<?> getAllbbevents(@RequestParam Map<String, String> dates) {
        List<BaseBallEvent> bbevents = bbEvent.getAllBaseBallEvents();
        return ResponseEntity.status(HttpStatus.OK).body(bbevents);
    }

    
    @RequestMapping(method = RequestMethod.GET, path = "/{bbevent_id}", produces = "application/json")
    @ApiOperation(value = "Returns list Base ball events/tournaments for the mentioned id")
    
    public ResponseEntity<?> getbbeventById(@PathVariable Long bbevent_id) {
        BaseBallEvent bbevent = bbEvent.getBaseBallEventById(bbevent_id);
        return ResponseEntity.status(HttpStatus.OK).body(bbevent);
    }
    
    
    @RequestMapping(method = RequestMethod.POST, path = "/", produces = "application/json")
    @ApiOperation(value = "Creates new baseball event that will regisgtered in the system")
    public ResponseEntity<BaseBallEvent> createEvent(@ApiParam("create new event.")
    								@RequestBody BaseBallEvent baseBallEvent) {
    	BaseBallEvent bbevents = bbEvent.pushBaseBallEvent(baseBallEvent);
        return ResponseEntity.status(HttpStatus.OK).body(baseBallEvent);
    }

    
    @RequestMapping(method = RequestMethod.PUT, path = "/", produces = "application/json")
    @ApiOperation(value = "updates existing  baseball event that will regisgtered in the system")
    public ResponseEntity<BaseBallEvent> updateEvent(@ApiParam("update new event.")
    								@RequestBody BaseBallEvent baseBallEvent) {
    	BaseBallEvent bbevents = bbEvent.updateBaseBallEvent(baseBallEvent,baseBallEvent.getId());
        return ResponseEntity.status(HttpStatus.OK).body(baseBallEvent);
    }

  
    @RequestMapping(method = RequestMethod.GET, path = "/{bbevent_id}/games", produces = "application/json")
    @ApiOperation(value = "Request to fetch all the games for a particular event/tournament")
    public ResponseEntity<?> getAllGameBybbeventId(@PathVariable Long bbevent_id) {
        List<Game> games = bbEvent.getAllGamesByEventId(bbevent_id);
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

    
    @RequestMapping(method = RequestMethod.DELETE, path = "/{bbevent_id}", produces = "application/json")
    @ApiOperation(value = "deletes the event  for a sent id")
    public ResponseEntity<?> deletebbeventById(@PathVariable Long bbevent_id) {
        bbEvent.deleteBaseBallEvent(bbevent_id);
        return ResponseEntity.noContent().build();
    }
}

