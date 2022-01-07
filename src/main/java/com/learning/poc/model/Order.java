package com.learning.poc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ORDERS")

public class Order {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private Integer id;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public String getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	@Column(name="SHIPPING_ADDRESS")
	private String shippingAddress;
	
	@Column(name="BILLING_ADDRESS")
	private String billingAddress;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	
	@ManyToMany
	@JoinTable(name="ORDER_ITEMS",joinColumns = {@JoinColumn (name = "ORDER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") })
	@JsonIgnore
	private Set<Product> products=new HashSet<>();
}
