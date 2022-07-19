package org.la.dodgers.baseball.controllers;

 
import org.la.dodgers.baseball.domain.Game;
import org.la.dodgers.baseball.domain.Game;
import org.la.dodgers.baseball.exception.TicketsUnavailableException;
import org.la.dodgers.baseball.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController


@RequestMapping("/v2/games")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of game.")

public class GameController {
    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

     
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public ResponseEntity<?> getAllGames(@RequestParam(required = false) Map<String, String> dates) {
        List<Game> screenings = null;
        if(!dates.isEmpty()) {
            LocalDate startDate = LocalDate.parse(dates.get("startDate"));
            LocalDate endDate = LocalDate.parse(dates.get("endDate"));
            screenings = gameService.getAllGames(startDate, endDate);
        } else {
            screenings = gameService.getAllGames();
        }
        return ResponseEntity.status(HttpStatus.OK).body(screenings);
    }

     
    @RequestMapping(method = RequestMethod.GET, path = "/{game_id}", produces = "application/json")
    public ResponseEntity<?> getGameById(@PathVariable Long game_id) {
        Game screening = gameService.getGameById(game_id);
        return ResponseEntity.status(HttpStatus.OK).body(screening);
    }

  
    
    @RequestMapping(method = RequestMethod.POST, path = "/", produces = "application/json")
    @ApiOperation(value = "Creates new game in the system")
    public ResponseEntity<Game> creategame(@ApiParam("create new game.")
    								@RequestBody Game game) {
    	Game game1 = gameService.pushGame(game);
        return ResponseEntity.status(HttpStatus.OK).body(game1);
    }

    
    @RequestMapping(method = RequestMethod.PUT, path = "/", produces = "application/json")
    @ApiOperation(value = "updates existing  game in the system")
    public ResponseEntity<Game> updategame(@ApiParam("update new game.")
    								@RequestBody Game game) {
    	Game b1 = gameService.updateGame(game, new Long(game.getId()));
    
        return ResponseEntity.status(HttpStatus.OK).body(b1);
    }
    
  
    
}
