package controller.view;


import javax.validation.Valid;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.fabric.xmlrpc.base.Data;

import model.Student;

@Controller
public class ViewController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
		
	}
	
	@RequestMapping("/login.html")
	public String login() {
		
		return "login";
		
	}

	 @RequestMapping("/studentregistration.html")
	 public String registerStudent() {
	 
		 
		 return "studentregistration";
	 }
	 

	 @RequestMapping("/companyregistration.html")
	 public String registerCompany() {
	  
		 return "companyregistration";
	 }
	 
	 @RequestMapping("/student.html/{username}")
	 public String student(@PathVariable(value = "username") String username, Model model) {
	  
		 model.addAttribute("username", username);
		 
		 return "student";
	 }
	 
	 @RequestMapping("/company.html")
	 public String company(Model model) {
	  
		 return "company";
	 }
	 

}
