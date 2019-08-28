package com.eddy.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.eddy.pojo.User;
import com.eddy.service.UserService;
import com.eddy.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/{userId}")
	public JsonResult<User> getUser(@PathVariable Integer userId) {
		log.info("get user, userId="+userId);
		User u = userService.getUser(userId);
		return JsonResult.ok(u);
	}
	
	@GetMapping("/{userId}/score") 
	public JsonResult addScore(
			@PathVariable Integer userId, Integer score) {
		userService.addScore(userId, score);
		return JsonResult.ok();
	}
}
