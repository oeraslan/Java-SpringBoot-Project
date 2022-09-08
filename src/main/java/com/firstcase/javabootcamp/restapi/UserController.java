package com.firstcase.javabootcamp.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstcase.javabootcamp.entities.User;
import com.firstcase.javabootcamp.services.IUserService;



@RestController
@RequestMapping("/api/users")
public class UserController {

	private IUserService userService;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}

	@GetMapping("")
	public List<User> get() {
		return userService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody User user) {
		userService.add(user);
	}

	@PutMapping("/update")
	public void update(@RequestBody User user) {
		userService.update(user);
	}

	@DeleteMapping("/{id}/delete")
	public void delete(@PathVariable long id) {
		userService.delete(id);
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable long id) {
		return userService.getById(id);
	}

}
