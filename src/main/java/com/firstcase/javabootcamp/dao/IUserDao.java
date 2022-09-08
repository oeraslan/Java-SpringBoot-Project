package com.firstcase.javabootcamp.dao;
import java.util.List;

import com.firstcase.javabootcamp.entities.User;

public interface IUserDao {

	List<User>  getAll();
	void add(User user);
	void update(User user);
	void delete(long id);
	User getById(long id);
	
}
