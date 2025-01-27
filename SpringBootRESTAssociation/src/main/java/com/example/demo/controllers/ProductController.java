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
import com.example.demo.entities.ProductDummy;
import com.example.demo.services.CatergoryService;
import com.example.demo.services.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	ProductService pservice;
	
	@Autowired
	CatergoryService cservice;
	
	@GetMapping("/getAllProducts")
	public List<Product> getAll(){
		return pservice.getAll();
	}
	
	@GetMapping("/getProduct/{pid}")
	public Product getProduct(@PathVariable  int pid){
		return pservice.getOne(pid);
	}
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody ProductDummy p) {
		Category c = cservice.getOne(p.getCid());
		Product pr = new Product();
		pr.setPname(p.getPname());
		pr.setPdesc(p.getPdesc());
		pr.setPrice(p.getPrice());
		pr.setCid(c);
		
		return pservice.save(pr);
		
	}
	
	
}
