package com.example.demo.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	@Id
	@Column(name="c_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cid;
	
	@Column(name="c_name")
	String cname;
	
	@Column(name="c_description")
	String cdesc;
	
	@JsonIgnoreProperties("cid")
	@OneToMany(mappedBy = "cid",cascade = CascadeType.ALL)
	Set<Product> products;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int cid, String cname, String cdesc) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdesc = cdesc;
	}	

	public Category(int cid, String cname, String cdesc, Set<Product> products) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdesc = cdesc;
		this.products = products;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		for(Product p : products) {
			p.setCid(this);
		}
		this.products = products;
	}
	
	
}
