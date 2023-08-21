package com.springboot.order_project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.order_project.dto.UserDto;
import com.springboot.order_project.service.UserService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController { // use HttpSesssion in orderController

	@Autowired
	UserService service;
	private HttpSession session;

	@PostMapping("/signup")
	public String insert(@RequestBody UserDto dto) {
		return service.insert(dto);
	}

	@PostMapping("/login")
	public String login(@RequestBody UserDto dto, HttpServletRequest request) {
		session = request.getSession();
		return service.login(dto, session);
	}

	@RequestMapping("/logout")
	public String logout() {
		return service.logout(session);
	}

	@DeleteMapping("/delete")
	public String delete(@RequestBody UserDto userDto) {
		return service.delete(userDto);
	}

	@GetMapping("/session")
	public String getSession() {
		System.out.println(session);
		return session.getId();
	}
	@GetMapping("/getupdate")
	public UserDto getUpdateProfile() {
		return service.getUpdateProfile();
	}
	@PutMapping("/update")
	public String updateProfile(@RequestBody UserDto userDto) {
		return service.updateProfile(userDto);
	}
}
