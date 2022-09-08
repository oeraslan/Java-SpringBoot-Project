package com.firstcase.javabootcamp.dao;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.firstcase.javabootcamp.entities.Product;

@Repository
public class ProductDao implements IProductDao {

	private EntityManager entityManager;

	@Autowired
	public ProductDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional // Aspect oriented programming
	public List<Product> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Product> products = session.createQuery("from Product", Product.class).getResultList();
		return products;
	}

	@Override
	@Transactional
	public void add(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(product);
	}

	@Override
	@Transactional
	public void update(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(product);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Session session = entityManager.unwrap(Session.class);
		Product delProduct = session.get(Product.class, id);
		delProduct.setDeleted(true);
	}

	@Override
	@Transactional
	public Product getById(long id) {
		Session session = entityManager.unwrap(Session.class);
		Product product = session.get(Product.class, id);
		return product;
	}

	@Override
	@Transactional
	public List<Product> getExpiredProduct() {
		Session session = entityManager.unwrap(Session.class);
		Calendar currentDate = Calendar.getInstance();
		List<Product> products = session
				.createQuery("select c from Product c Where c.expireDate < :curentDate ", Product.class)
				.setParameter("curentDate", currentDate, TemporalType.DATE).getResultList();
		return products;
	}

	@Override
	@Transactional
	public List<Product> getFreshProduct() {
		Session session = entityManager.unwrap(Session.class);
		Calendar currentDate = Calendar.getInstance();
		List<Product> products = session
				.createQuery("select c from Product c Where c.expireDate > :curentDate  or c.expireDate is null ",
						Product.class)
				.setParameter("curentDate", currentDate, TemporalType.DATE).getResultList();
		return products;
	}

}
