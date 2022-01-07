package com.learning.poc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.poc.ResourceNotFoundException;
import com.learning.poc.model.Order;
import com.learning.poc.model.OrderDetails;
import com.learning.poc.repository.OrderRepository;
import com.learning.poc.repository.ProductRepository;

@RestController
@RequestMapping("orderDetails")
public class OrderController {
	
	
	@Autowired 
	private OrderRepository orderrepo;
	
	@Autowired 
	private ProductRepository productrepo;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderDetails> getOrderDetailsById(@PathVariable Integer orderId)
	{
	Optional<Order> orders=orderrepo.findById(orderId);
	
	if(orders.isPresent())
	{
		
		OrderDetails orderdetails=new OrderDetails();
		orderdetails.setOrderId(orders.get().getId());
		orderdetails.setShippingAddress(orders.get().getShippingAddress());
		orderdetails.setBillingAdress(orders.get().getBillingAddress());
		orderdetails.setQuantity(orders.get().getQuantity());
		orderdetails.setProductList(orders.get().getProducts());
		return ResponseEntity.ok().body(orderdetails);
		
	}
	else
	{
		throw new ResourceNotFoundException("Order details not present in DB for order Id----"+orderId);
	
		
	}
	
	}
}
