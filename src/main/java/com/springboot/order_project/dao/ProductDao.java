package com.springboot.order_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.order_project.dto.ProductDto;
import com.springboot.order_project.repository.ProductRepository;

@Service
public class ProductDao {

	@Autowired
	ProductRepository productRepository;

	public String insert(ProductDto productDto) {
		productRepository.save(productDto);
		return null;
	}

	public List<ProductDto> fetchAll() {
		List<ProductDto> dtos=productRepository.findAll();
		return dtos;
	}

	public String delete(int productId) {
		try {
		productRepository.deleteById(productId);
		}catch(Exception e) {
			return "Product ID does not exist";
		}
		return "Product deleted successfully";
	}
}
