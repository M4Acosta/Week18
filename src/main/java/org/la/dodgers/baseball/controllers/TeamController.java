package org.la.dodgers.baseball.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.la.dodgers.baseball.domain.Team;
import org.la.dodgers.baseball.domain.Team; 
import org.la.dodgers.baseball.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/teams")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of teams.")
public class TeamController {

	private TeamService teamService;

	@Autowired
	public TeamController(TeamService theteamService) {
		teamService = theteamService;
	}

	// Endpoint for GET /v2/teams -- Get All teams
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ApiOperation("${teamcontroller.getallteams}")
	public List<Team> getAllteams() {
		return teamService.getAllTeams();
	}

	// Endpoint for GET /v2/teams/id -- Get Specific team
	@RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
	@ApiOperation("${teamcontroller.getteambyid}")
	public Team getteamById(@ApiParam("Id of the team to be obtained. Cannot be empty.") @PathVariable int id) {

		Team theteam = teamService.getTeamById(id);

		return theteam;
	}
	
	
	   
    @RequestMapping(method = RequestMethod.POST, produces = "application/json") 
    @ApiOperation(value = "Returns Hello World")
    public Team createTeam(@ApiParam("create new team.")
                                   @RequestBody Team team) { 
    	team.setId(0);
    	teamService.saveTeam(team);
        return team;
    }
    
    
    
    

}
