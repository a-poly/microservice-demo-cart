package com.example;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CartController {

	@Autowired ItemRepository repo;

	
	/**
	 * Get a list of all products:
	 */
	@GetMapping("/carts/{customer}")
	public Iterable<Item> getCart(@PathVariable String customer) {
		return repo.findByCustomer(customer);
	}

	
	
	/**
	 * Add a new item to a customer's cart:
	 */
	@PostMapping("/carts/{customer}")
	public HttpEntity<Void> addToCart(@PathVariable String customer, @RequestBody Item item) {
		if (item.getCustomer() == null ) item.setCustomer(customer);
		repo.save(item);
		
		URI location = ServletUriComponentsBuilder
	       .fromCurrentRequestUri()
	       .path("/items/{code}")
	       .buildAndExpand(item.getCode())
	       .toUri(); ;

	    return ResponseEntity.created(location).build();		
	}

	
	/**
	 * Change a product on PUT:
	 */
	@PutMapping("/carts/{customer}/items/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct( @PathVariable String customer, @PathVariable String code, @RequestBody Item item) {
		if ( item.getCustomer() == null ) item.setCustomer(customer);
		if ( item.getCode() == null ) item.setCode(code);
		
		repo.save(item);
	}

	/**
	 * Remove a customers entire cart:
	 */
	@DeleteMapping("/carts/{customer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable String customer) {
		repo.deleteAll( repo.findByCustomer(customer) );
	}

	
	
	/**
	 * Here is some built in test data.
	 */
	@PostConstruct
	public void init() {
		repo.save( new Item("111", "AAA", 1));
		repo.save( new Item("111", "BBB", 1));
		repo.save( new Item("222", "CCC", 1));
		repo.save( new Item("222", "DDD", 1));
		repo.save( new Item("222", "EEE", 1));
		repo.save( new Item("333", "DDD", 1));
		repo.save( new Item("333", "EEE", 1));
	}

}
