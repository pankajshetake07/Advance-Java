package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository prepo;
	
	public List<Product> getAll() {
		return prepo.findAll();
	}
	
	public Product getOne(int pid) {
		return prepo.findById(pid).get();
	}
	
	public Product save(Product p) {
		return prepo.save(p);
	}
}
