package com.techhmr.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techhmr.userservice.VO.ResponseTemplate;
import com.techhmr.userservice.entities.User;
import com.techhmr.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user){
		log.info("Inside saveDepartment of UserController");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplate getUserWithDepartment(@PathVariable(value="id") Long userId){
		log.info("Inside getUserWithDepartment of UserController");
		return userService.getUserWithDepartment(userId);
	}
}
