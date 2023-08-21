package com.springboot.order_project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.order_project.dto.OrderDto;
import com.springboot.order_project.service.OrderService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService service;
	private HttpSession session;
	
	@PostMapping("/insert/{id}")
	public String insert(@PathVariable int id) {
		System.out.println("Hiiiiiiiiiiiii");
		System.out.println(session.getId());
		return service.insert(id,session);
	}
	@GetMapping("/fetchall")
	public Object fetchAll(){
		List<OrderDto> obj=service.fetchAll(session);
		if(obj==null) {
			return "You have to login as User in order to see Order History";
		}
		return obj;
	}
	public void getSession(HttpSession session) {
		this.session=session;
	}
}
