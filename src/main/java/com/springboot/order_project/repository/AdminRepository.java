package com.springboot.order_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.order_project.dto.AdminDto;

@Repository
public interface AdminRepository extends JpaRepository<AdminDto, Integer>{

}
