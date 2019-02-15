package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * Automatically generate methods for save, findAll, etc. for Item.
 * 
 */
public interface ItemRepository extends CrudRepository<Item, Long>{

	public Iterable<Item> findByCustomer(String customer);
	
}
