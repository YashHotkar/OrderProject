package com.springboot.order_project.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.order_project.dao.OrderDao;
import com.springboot.order_project.dto.OrderDto;
import com.springboot.order_project.dto.ProductDto;
import com.springboot.order_project.dto.UserDto;
import com.springboot.order_project.repository.ProductRepository;
import com.springboot.order_project.repository.UserRepository;

@Service
public class OrderService {

	@Autowired
	OrderDao dao;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;

//	public String insert(OrderDto dto) {
//		// TODO Auto-generated method stub
//		return dao.insert(dto);
//	}
	
	public String insert(int id,HttpSession session) {
		Optional<ProductDto> opProductDto=productRepository.findById(id);
		System.out.println(session.getId());
		Optional<UserDto> opuserDto=userRepository.findById((int)session.getAttribute("customerId"));
			UserDto userDto=opuserDto.get();
			ProductDto productDto=opProductDto.get();
			OrderDto orderDto=new OrderDto();
			orderDto.setProductId(productDto.getProductId());
			orderDto.setProductName(productDto.getProductName());
			orderDto.setPrice(productDto.getPrice());
			
			orderDto.setUserDto(userDto);
			
			System.out.println(orderDto.getUserDto().getCustomerId());
			System.out.println(session.getAttribute("customerId"));
			System.out.println("This is service class");
			return dao.insert(orderDto);
	}

	public List<OrderDto> fetchAll(HttpSession session) {
		if(session.getAttribute("username")==null) {
			return null;
		}
		return dao.fetchAll();
	}

}
