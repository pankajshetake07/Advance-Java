package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.services.CatergoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CategoryController {
	
	@Autowired
	CatergoryService cservice;
	
	@GetMapping("/getAllCategory")
	public List<Category> getAll(){
		return cservice.getAll();
	}
	
	@GetMapping("/getCategory/{cid}")
	public Category getProduct(@PathVariable  int cid){
		return cservice.getOne(cid);
	}
	
	@PostMapping("/saveCat")
	public Category saveCat(@RequestBody Category c) {
		return cservice.save(c);
	}

}
