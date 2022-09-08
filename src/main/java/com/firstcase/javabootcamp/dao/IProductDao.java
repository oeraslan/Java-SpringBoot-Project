package com.firstcase.javabootcamp.dao;

import java.util.List;

import com.firstcase.javabootcamp.entities.Product;

public interface IProductDao {

	List<Product> getAll();

	void add(Product product);

	void update(Product product);

	void delete(long id);

	Product getById(long id);

	List<Product> getExpiredProduct();

	List<Product> getFreshProduct();

}
