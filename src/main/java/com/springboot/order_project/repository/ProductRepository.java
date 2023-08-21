package com.springboot.order_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.order_project.dto.ProductDto;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, Integer>{

}
