package com.opentext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.model.User;
import com.opentext.services.UserService;

//Swagger URL http://localhost:8080/swagger-ui.html

@RestController
public class UserContoller {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getUsers/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Integer id) throws Exception {
		User user = new User();
		user.setId(1);
		return userService.getUser(id);
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getAllUsers() throws Exception {
		return userService.geAlltUsers();
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) throws Exception {
		return userService.saveUser(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateUser/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Integer id) throws Exception {

		return userService.updateUser(user, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{id}")
	public void updateUser(@PathVariable Integer id) throws Exception {
		userService.deleteUser(id);
	}

}
