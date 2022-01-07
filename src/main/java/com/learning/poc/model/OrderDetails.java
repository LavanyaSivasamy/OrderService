package com.learning.poc.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class OrderDetails {
	
	private Integer orderId;
	private String shippingAddress;
	private String billingAdress;
	private Integer quantity;
	Set<Product> productList=new HashSet();
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBillingAdress() {
		return billingAdress;
	}
	public void setBillingAdress(String billingAdress) {
		this.billingAdress = billingAdress;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Set<Product> getProductList() {
		return productList;
	}
	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}
	


}
