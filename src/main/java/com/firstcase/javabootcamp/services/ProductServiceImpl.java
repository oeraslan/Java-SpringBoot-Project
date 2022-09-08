package com.firstcase.javabootcamp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.firstcase.javabootcamp.dao.IProductDao;
import com.firstcase.javabootcamp.entities.Product;

@Service
public class ProductServiceImpl implements IProductService {

	private IProductDao productDal;

	@Autowired
	public ProductServiceImpl(IProductDao productDal) {
		this.productDal = productDal;
	}

	@Override
	@Transactional
	public List<Product> getAll() {

		return this.productDal.getAll();
	}

	@Override
	@Transactional
	public void add(Product product) {
		this.productDal.add(product);

	}

	@Override
	@Transactional
	public void update(Product product) {
		this.productDal.update(product);

	}

	@Override
	@Transactional
	public void delete(long id) {
		this.productDal.delete(id);

	}

	@Override
	@Transactional
	public Product getById(long id) {
		return this.productDal.getById(id);
	}

	@Override
	public List<Product> getExpiredProduct() {

		return this.productDal.getExpiredProduct();
	}

	@Override
	public List<Product> getFreshProduct() {

		return this.productDal.getFreshProduct();
	}

}
