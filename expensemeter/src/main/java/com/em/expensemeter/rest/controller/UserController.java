package com.em.expensemeter.rest.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.em.expensemeter.model.User;
import com.em.expensemeter.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> userList = null;
		userList = userService.getAllUsers();
		if(userList == null){
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> loadUserDetailsByUserName(@PathVariable String username) {
		User vo = userService.loadUserDetailsByUserName(username);

		if(vo == null){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(vo, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user) {

		userService.updateUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> removeUser(@PathVariable BigInteger id) {
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorHandler(Exception e) {
		System.out.println("In exception handlet..");
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
