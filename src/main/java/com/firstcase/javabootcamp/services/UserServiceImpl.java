package com.firstcase.javabootcamp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstcase.javabootcamp.dao.IUserDao;
import com.firstcase.javabootcamp.entities.User;

 @Service
public class UserServiceImpl implements IUserService{

	
	private IUserDao userDal;
	
	@Autowired
	public UserServiceImpl(IUserDao userDal) {
		this.userDal = userDal;
	}

	@Override
	@Transactional
	public List<User> getAll() {
		return this.userDal.getAll();
	}

	@Override
	@Transactional
	public void add(User user) {
		this.userDal.add(user);
		
	}

	@Override
	@Transactional
	public void update(User user) {
		this.userDal.update(user);
		
	}

	@Override
	@Transactional
	public void delete(long id) {
		this.userDal.delete(id);
		
	}

	@Override
	@Transactional
	public User getById(long id) {
		
		return this.userDal.getById(id);
	}

}
