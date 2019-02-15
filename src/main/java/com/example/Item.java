package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An item in a shopping cart.  Potentially several items of a given type.
 */
@Entity
@Table(name="item")
public class Item {

	private Long id;
	private String customer;
	private String code;
	private Long quantity;
	

	public Item() {
		super();
	}

	public Item(String customer, String code, Long quantity) {
		this();
		this.customer = customer;
		this.code = code;
		this.quantity = quantity;
	}	
	
	public Item(String customer, String code, Integer quantity) {
		this(customer, code, new Long(quantity));
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
}
