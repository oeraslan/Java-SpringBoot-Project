package com.firstcase.javabootcamp.services;

import java.util.List;

import com.firstcase.javabootcamp.entities.User;

public interface IUserService {

	List<User> getAll();

	void add(User user);

	void update(User user);

	void delete(long id);

	User getById(long id);
}
