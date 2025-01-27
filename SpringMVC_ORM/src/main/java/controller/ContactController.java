package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ContactDAO;
import entities.Contact;

@Controller
public class ContactController {

	//no setter method, no property element
	@Autowired
	ContactDAO cdao;
	
	@RequestMapping("/all")
	public ModelAndView getAllContacts() {
		List<Contact> clist = cdao.getAll();
		return new ModelAndView("all", "clist", clist);
	}
	
	@RequestMapping("/create")
	public ModelAndView getInfo() {
		Contact ct = new Contact();  //empty
		return new ModelAndView("contactform","newcontact",ct);
	}
	
	@RequestMapping("/insert")
	public ModelAndView insertContact(@ModelAttribute("newcontact")  Contact ct) {
		int cid = cdao.save(ct);
		return new ModelAndView("insertmsg","newid",cid);
	}
	
	@RequestMapping("/editcontact")
	public ModelAndView editContact(HttpServletRequest request) {
		//edit form - show existing values
		//get new info
		int cid = Integer.parseInt(request.getParameter("cid"));
		Contact ct = cdao.get(cid);
		return new ModelAndView("editform","tobeedited",ct);
		
	}
	
	@RequestMapping("/update")
	public void upodateContact() {
		
	}
	
	@RequestMapping("/deletecontact")
	public void deleteContact(HttpServletRequest request) {
		//read cid
		//dao - delete contact
		
	}
	
	
}
