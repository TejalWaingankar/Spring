package com.sync.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sync.rest.exception.UserNotFoundException;
import com.sync.rest.model.User;
import com.sync.rest.service.UserDaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Swagger2UserController")
public class UserController {

	@Autowired
	private UserDaoService service;

	@ApiOperation(value = "Get list of users in the System ", response = List.class)
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@ApiOperation(value = "Get single user in the System ", response = User.class)
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		return user;
	}

	@ApiOperation(value = "Delete a user in the System ", response = ResponseEntity.class)
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "Create a user in the System ", response = ResponseEntity.class)
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user /*, BindingResult binding*/) {
		
		/*
		 * Validation can also be checked using BindingResult param in controller itself
		 *  to check if the validations are met or not like below,
		 *  
		 *  Else, override handleMethodArgumentNotValid in GlobalException class to tackle the exception there.
		 * 
		 * if(binding.hasErrors()) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed in controller",
					binding.toString());
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
		}*/
		
		User savedUser = service.save(user);

		return new ResponseEntity<Object>(savedUser, HttpStatus.CREATED);
	}
	
}
