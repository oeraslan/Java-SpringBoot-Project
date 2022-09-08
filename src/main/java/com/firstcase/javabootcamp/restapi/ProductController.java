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

import com.firstcase.javabootcamp.entities.Product;
import com.firstcase.javabootcamp.services.IProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private IProductService productService;

	@Autowired
	public ProductController(IProductService productService) {
		this.productService = productService;
	}

	@GetMapping("")
	public List<Product> getProduct() {
		return productService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody Product product) {
		productService.add(product);

	}

	@PutMapping("/update")
	public void update(@RequestBody Product product) {
		productService.update(product);
	}

	@DeleteMapping("/{id}/delete")
	public void delete(@PathVariable long id) {
		productService.delete(id);
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable long id) {
		return productService.getById(id);
	}

}
