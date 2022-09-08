package com.firstcase.javabootcamp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firstcase.javabootcamp.entities.User;

@Repository
public class UserDao implements IUserDao {

	private EntityManager entityManager;

	@Autowired
	public UserDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional // Aspect oriented programming
	public List<User> getAll() {
		System.out.println("---------------------dao");
		Session session = entityManager.unwrap(Session.class);
		List<User> users = session.createQuery("from User", User.class).getResultList();
		return users;
	}

	@Override
	@Transactional
	public void add(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void update(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Session session = entityManager.unwrap(Session.class);
		User delUser = session.get(User.class, id);
		delUser.setDeleted(true);
		
	}

	@Override
	@Transactional
	public User getById(long id) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

}
