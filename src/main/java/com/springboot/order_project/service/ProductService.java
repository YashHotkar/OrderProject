package com.springboot.order_project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.order_project.dao.ProductDao;
import com.springboot.order_project.dto.ProductDto;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	public String insert(ProductDto productDto,HttpSession session) {
		if(session.getAttribute("AdminUserName")==null) {
			return "You have to login as admin in order to insert record in the products table";
		}
		return dao.insert(productDto);
	}

	public List<ProductDto> fetchAll() {
		// TODO Auto-generated method stub
		return dao.fetchAll();
	}

	public String delete(int productId, HttpSession session) {
		if(session.getAttribute("AdminUserName")==null) {
			return "You have to login in order to edit the products table";
		}
		return dao.delete(productId);
	}
	
	
	
}
