package com.springboot.order_project.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.order_project.controller.OrderController;
import com.springboot.order_project.controller.ProductController;
import com.springboot.order_project.dao.OrderDao;
import com.springboot.order_project.dao.UserDao;
import com.springboot.order_project.dto.OrderDto;
import com.springboot.order_project.dto.UserDto;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderController orderController;
	@Autowired
	ProductController productController;
	HttpSession session;

	public String insert(UserDto dto) {
		return dao.insert(dto);
	}

	public String login(UserDto dto, HttpSession session) {
//		String un = (String) session.getAttribute("username");
		this.session = session;
		List<UserDto> dtos = dao.fetchAll();
		if (!dtos.isEmpty()) {
			for (UserDto ud : dtos) {
				if (ud.getUserName().equals(dto.getUserName())) {
					if (ud.getPassword().equals(dto.getPassword())) {
						session.setAttribute("username", ud.getUserName());
						session.setAttribute("password", ud.getPassword());
						session.setAttribute("customerId", ud.getCustomerId());
						System.out.println(session.getAttribute("customerId"));
						System.out.println(session.getId());
						productController.getSession(session);
						orderController.getSession(session);
						;

						return "Successfully Logged In";
					}
					return "Username and password does not match";
				} else {
					return "Username Does not exist";
				}
			}
		}
		return "Username Does not exist";
	}

	public String logout(HttpSession session) {
//		System.out.println(session.getAttribute("username"));
//		System.out.println(session.getAttribute("password"));
//		System.out.println(session.getAttribute("customerId"));
		if(session!=null) {
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.removeAttribute("customerId");
		}
		return "Successfully Logged Out";
	}

	public String delete(UserDto userDto) {
		List<UserDto> dtos = dao.fetchAll();
		for (UserDto ud : dtos) {
			if (ud.getUserName().equals(userDto.getUserName())) {
				if (ud.getPassword().equals(userDto.getPassword())) {
					List<OrderDto> orderDtos = orderDao.fetchAll();
					if (!orderDtos.isEmpty()) {
						for (OrderDto od : orderDtos) {
							if (od.getUserDto().getCustomerId() == ud.getCustomerId()) {
								orderDao.delete(od);
							}
						}
					}
					return dao.delete(ud);
				} else {
					return "Enter correct password";
				}
			}
		}
		return "Username not found";
	}

	public UserDto getUpdateProfile() {
		
		Optional<UserDto> op=dao.getUpdateProfile(session);
		UserDto dto=op.get();
		return dto;
	}

	public String updateProfile(UserDto userDto) {
		
		return dao.updateProfile(userDto);
	}
}
