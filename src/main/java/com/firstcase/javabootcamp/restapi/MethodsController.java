package com.firstcase.javabootcamp.restapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstcase.javabootcamp.entities.Comment;
import com.firstcase.javabootcamp.entities.Product;
import com.firstcase.javabootcamp.services.ICommentService;
import com.firstcase.javabootcamp.services.IProductService;

@RestController
@RequestMapping("/api/methods")
public class MethodsController {

	private ICommentService commentService;
	private IProductService productService;

	@Autowired
	public MethodsController(ICommentService commentService, IProductService productService) {
		super();
		this.commentService = commentService;
		this.productService = productService;
	}

	@GetMapping("/products/{productID}/comments/{startDate}/{finishDate}")
	public List<Comment> getcommentWithDate(@PathVariable(name = "productID", required = true) Long productID,
			@PathVariable(name = "startDate", required = true) String startDateStr,
			@PathVariable(name = "finishDate", required = true) String finishDateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(sdf.parse(startDateStr));
			Calendar finishDate = Calendar.getInstance();
			finishDate.setTime(sdf.parse(finishDateStr));
			return commentService.getcommentWithDate(productID, startDate, finishDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	@GetMapping("/users/{userID}/comments/{startDate}/{finishDate}")
	public List<Comment> getUserCommentsWithDate(@PathVariable(name = "userID", required = true) Long userID,
			@PathVariable(name = "startDate", required = true) String startDateStr,
			@PathVariable(name = "finishDate", required = true) String finishDateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(sdf.parse(startDateStr));
			Calendar finishDate = Calendar.getInstance();
			finishDate.setTime(sdf.parse(finishDateStr));
			return commentService.getUserCommentsWithDate(userID, startDate, finishDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	@GetMapping("/products/{id}/comments")
	public List<Comment> getProductComments(@PathVariable long id) {
		return commentService.getProductComments(id);
	}

	@GetMapping("/users/{id}/comments")
	public List<Comment> getUserComments(@PathVariable long id) {
		return commentService.getUserComments(id);
	}

	@GetMapping("/products/expired")
	public List<Product> getExpiredProduct() {

		return productService.getExpiredProduct();

	}

	@GetMapping("/products/fresh")
	public List<Product> getFreshProduct() {

		return productService.getFreshProduct();

	}

}
