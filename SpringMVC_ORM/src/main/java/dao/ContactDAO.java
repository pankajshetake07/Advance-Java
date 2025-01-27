package dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import entities.Contact;

@Transactional
public class ContactDAO {
	
	//no setter method and no property element
	@Autowired
	HibernateTemplate template;
	
	//@Transactional(readOnly = true)
	public List<Contact> getAll(){
		return template.loadAll(Contact.class);
	}
	
	//@Transactional
	public int save(Contact ct) {
		return (int)template.save(ct);
	}
	
	public Contact get(int cid) {
		return template.get(Contact.class,cid);
	}
	
	
	

}
