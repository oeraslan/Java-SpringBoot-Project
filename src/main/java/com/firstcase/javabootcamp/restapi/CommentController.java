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

import com.firstcase.javabootcamp.entities.Comment;
import com.firstcase.javabootcamp.services.ICommentService;



@RestController
@RequestMapping("/api/comments")
public class CommentController {

	private ICommentService commentService;

	@Autowired
	public CommentController(ICommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("")
	public List<Comment> getcomment() {
		return commentService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody Comment comment) {
		commentService.add(comment);

	}

	@PutMapping("/update")
	public void update(@RequestBody Comment comment) {
		commentService.update(comment);
	}

	@DeleteMapping("/{id}/delete")
	public void delete(@PathVariable long id) {
		commentService.delete(id);
	}

	@GetMapping("/{id}")
	public Comment getById(@PathVariable long id) {
		return commentService.getById(id);
	}

}
