package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class CatergoryService {

	@Autowired
	CategoryRepository crepo;
	
	public List<Category> getAll() {
		return crepo.findAll();
	}
	
	public Category getOne(int pid) {
		return crepo.findById(pid).get();
	}
	
	public Category save(Category c) {
		return crepo.save(c);
	}
}
