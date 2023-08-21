package com.springboot.order_project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.order_project.dto.ProductDto;
import com.springboot.order_project.service.ProductService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService service;
	private HttpSession session;
	
	@PostMapping("/insert")
	public String insert(@RequestBody ProductDto productDto,HttpSession session) {
		return service.insert(productDto,session);
	}
	@GetMapping("/fetchall")
	public List<ProductDto> fetchAll(){
		return service.fetchAll();
	}
	@DeleteMapping("/delete/{productId}")
	public String delete(@PathVariable int productId) {
		return service.delete(productId,session);
	}
	public void getSession(HttpSession session) {
		this.session=session;
	}
}
