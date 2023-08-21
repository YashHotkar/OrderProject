package com.springboot.order_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.order_project.dto.AdminDto;
import com.springboot.order_project.repository.AdminRepository;

@Service
public class AdminDao {
	
	@Autowired
	AdminRepository adminRepository;

	public String insert(AdminDto adminDto) {
		adminRepository.save(adminDto);
		return "Account created in admin table";
	}
	public List<AdminDto> fetchAll() {
		List<AdminDto> dtos=adminRepository.findAll();
		return dtos;
	}
	public String delete(AdminDto dto) {
		adminRepository.delete(dto);
		return "User account deleted successfully";
	}
	
}
