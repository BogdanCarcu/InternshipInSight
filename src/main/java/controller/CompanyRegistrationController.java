package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Company;
import model.Student;
import service.CompanyService;
import service.StudentService;

@RestController
@RequestMapping("companyregistration")
public class CompanyRegistrationController {


	 private final CompanyService companyService;

	    @Autowired
	    public CompanyRegistrationController(CompanyService companyService) {
	        this.companyService = companyService;
	    }

	    @PostMapping("")
	    public String registerCompany(@RequestBody Company company) {
	        try {
	            Company c =  companyService.saveCompany(company);
	            if(c != null)
	            	return "index";
	            
	            return "companyregistration";
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "companyregistration";
	        }
	    }
	    
	
}
