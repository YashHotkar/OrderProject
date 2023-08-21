package com.springboot.order_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.order_project.dto.OrderDto;
import com.springboot.order_project.repository.OrderRepository;

@Service
public class OrderDao {

	@Autowired
	OrderRepository orderRepository;
	
	
//	public Optional<UserDto> findCustomerId(OrderDto dto,HttpSession session) {
//		System.out.println(1);
//		
//		return userDto;
//	}

	public String insert(OrderDto dto) {
		orderRepository.save(dto);
		return "Data inserted into order table";
	}
	public List<OrderDto> fetchAll(){
		List<OrderDto> dtos=orderRepository.findAll();
		System.out.println("this is orders fetchall");
		return dtos;
	}
	public void delete(OrderDto od) {
		orderRepository.delete(od);
	}
}
