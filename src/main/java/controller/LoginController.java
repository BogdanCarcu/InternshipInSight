package controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Company;
import model.IUser;
import model.Student;
import service.CompanyService;
import service.StudentService;
import springfox.documentation.spring.web.json.Json;

@RestController
@RequestMapping("login")
public class LoginController {

	 private final CompanyService companyService;
	 private final StudentService studentService;
	 
	 @Autowired
	 public LoginController(CompanyService companyService, StudentService studentService) {
		 
		 this.companyService = companyService;
		 this.studentService = studentService;
		 
	 }
	 
	 @GetMapping("")
	 public IUser login(@RequestParam(required = true) String username, 
			 @RequestParam(required = true) String password) {
		 
		 Student student = studentService.getStudentByUsernameAndPassword(username, password);
		 
		 if(student != null) {
			 
			 return student;
		 
		 }
		 else {
			 
			 Company company = companyService.getCompanyByUsernameAndPassword(username, password);
			 
			 if(company != null)
				return company;
			
			 return null;
	
		 }
		 
	 }
	
}
