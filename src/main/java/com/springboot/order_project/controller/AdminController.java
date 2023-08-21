package com.springboot.order_project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.order_project.dto.AdminDto;
import com.springboot.order_project.service.AdminService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@PostMapping("/insert")
	public String insert(@RequestBody AdminDto adminDto,HttpSession session) {
		return service.insert(adminDto,session);
	}
	@GetMapping("/login")
	public String login(@RequestBody AdminDto dto,HttpSession session) {
		return service.login(dto,session);
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		return service.logout(session);
	}
	@DeleteMapping("/delete")
	public String delete(@RequestBody AdminDto adminDto) {
		return service.delete(adminDto);
	}
	@GetMapping("/session")
	public String getSession(HttpSession session) {
		return (String)session.getAttribute("username");
	}
}
