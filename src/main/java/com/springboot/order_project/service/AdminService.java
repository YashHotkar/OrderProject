package com.springboot.order_project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.order_project.dao.AdminDao;
import com.springboot.order_project.dto.AdminDto;

@Service
public class AdminService {

	@Autowired
	AdminDao dao;

	public String insert(AdminDto adminDto, HttpSession session) {
		return dao.insert(adminDto);
	}

	public String login(AdminDto dto, HttpSession session) {

		List<AdminDto> dtos = dao.fetchAll();
		if (!dtos.isEmpty()) {
			for (AdminDto ad : dtos) {
				if (ad.getUserName().equals(dto.getUserName())) {
					if (ad.getPassword().equals(dto.getPassword())) {
						session.setAttribute("username", ad.getUserName());
						session.setAttribute("password", ad.getPassword());

						session.removeAttribute("username");
						session.removeAttribute("password");
						return "Successfully Logged In";
					}
					return "Username and password does not match";
				}else {
					return "Username Does not exist";
				}
			}
		}
		return "Username Does not exist";
	}

	public String logout(HttpSession session) {
		System.out.println(session.getAttribute("username"));
		System.out.println(session.getAttribute("password"));
		session.removeAttribute("username");
		session.removeAttribute("password");
		return "Successfully Logged Out";
	}

	public String delete(AdminDto adminDto) {
		List<AdminDto> dtos = dao.fetchAll();
		for (AdminDto ad : dtos) {
			if (ad.getUserName().equals(adminDto.getUserName())) {
				if (ad.getPassword().equals(adminDto.getPassword())) {
					return dao.delete(ad);
				} else {
					return "Enter correct password";
				}
			}
		}
		return "Username not found";

	}
}
