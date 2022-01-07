package com.learning.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.poc.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	
}
