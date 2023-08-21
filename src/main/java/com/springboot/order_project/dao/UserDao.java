package com.springboot.order_project.dao;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.order_project.dto.UserDto;
import com.springboot.order_project.repository.UserRepository;

@Service
public class UserDao {
	@Autowired
	UserRepository userRepository;

	public String insert(UserDto dto) {
		userRepository.save(dto);
		return "Data inserted successfully";
	}

	public List<UserDto> fetchAll() {
		List<UserDto> dtos=userRepository.findAll();
		return dtos;
	}

	public String delete(UserDto dto) {
		userRepository.delete(dto);
		return "User account deleted successfully";
	}

	public Optional<UserDto> getUpdateProfile(HttpSession session) {
		Optional<UserDto> optional= userRepository.findById((int)session.getAttribute("customerId"));
		return optional;
	}

	public String updateProfile(UserDto userDto) {
		userRepository.save(userDto);
		return "Profile updated";
	}
}
