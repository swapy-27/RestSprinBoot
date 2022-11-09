package com.example.MicroservicesExample.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.MicroservicesExample.Exceptions.UserNotFoundException;
import com.example.MicroservicesExample.Model.User;
import com.example.MicroservicesExample.ServiceLayer.UserDaoService;
@RestController
public class UserController {
	@Autowired
	private UserDaoService userService;
	
	@GetMapping(path="/users")
	public List<User> getAllUser() {
		return userService.findAll();
	}
	@GetMapping(path="/users/{id}")
	public User getAllUser(@PathVariable int id) {
		User user =userService.findOne(id);
		
		if (user == null) {
			throw new UserNotFoundException("user not found"+id);
		}
		
		return user;
	}
	@PostMapping(path="users/create-user")
	public ResponseEntity<User> createNewUser(@RequestBody User user) {
		User saveduser= userService.save(user);
		
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/create-user/{id}").buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location).body(saveduser);
	}
	
}
