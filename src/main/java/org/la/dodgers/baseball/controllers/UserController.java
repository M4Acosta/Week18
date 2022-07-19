package org.la.dodgers.baseball.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.la.dodgers.baseball.domain.User;
import org.la.dodgers.baseball.exception.UserNotFoundException;
import org.la.dodgers.baseball.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/users")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of users.")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService theuserService) {
		userService = theuserService;
	}

	// Endpoint for GET /v2/users -- Get All users
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ApiOperation("${usercontroller.getallusers}")
	public List<User> getAllusers() {
		return userService.getAllUsers();
	}

	// Endpoint for GET /v2/users/id -- Get Specific user
	@RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
	@ApiOperation("${usercontroller.getuserbyid}")
	public User getuserById(@ApiParam("Id of the user to be obtained. Cannot be empty.") @PathVariable int id) {

		User theuser = userService.getUserById(new Long(id));

		if (theuser == null) {
			throw new UserNotFoundException("user Id not found - " + id);
		}

		return theuser;
	}

	// Endpoint for DELETE /v2/users -- Delete Specific user
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ApiOperation("${usercontroller.deleteuser}")
	public String deleteuser(@ApiParam("Id of the user to be deleted. Cannot be empty.") @PathVariable int id) {

		userService.deleteUserById(new Long(id));

		return "Deleted user Id - " + id;
	}

	// Endpoint for POST /v2/users -- Create a new user
	@RequestMapping(method = RequestMethod.POST,   produces = "application/json")
	@ApiOperation("${usercontroller.createuser}")
	public User createuser(@ApiParam("user information for a new user to be created.") @RequestBody User user) {
		System.out.println("########## user received is "+user);
		// Also just in case they pass an id in JSON ... set id to 0, this is to force a
		// save of new item ... instead of update.

		userService.pushUser(user);
		return user;
	}

	// Endpoint for PUT /v2/users -- Update an existing user
	@RequestMapping(method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation("${usercontroller.updateuser}")
	public User updateuser(
			@ApiParam(value = "user information for updating an existing user.") @RequestBody User user) {

		userService.updateUser(user, new Long(user.getId()));

		return user;
	}
}
