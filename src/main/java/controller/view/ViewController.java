package controller.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 
	 @RequestMapping("/company.html/{username}")
	 public String company(@PathVariable(value = "username") String username, Model model) {
	  
		 model.addAttribute("username", username);
		 
		 return "company";
	 }
	 
	 @RequestMapping("/internship.html/{username}")
	 public String internship(@PathVariable(value = "username") String username, Model model) {
		 
		 model.addAttribute("username", username);
		 
		 return "internship";
	 }

}
