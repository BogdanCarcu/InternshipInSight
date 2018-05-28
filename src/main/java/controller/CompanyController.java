package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Company;
import service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {
	
	 private final CompanyService companyService;

	    @Autowired
	    public CompanyController(CompanyService companyService) {
	        this.companyService = companyService;
	    }
	    
	    
	    @GetMapping("")
	    public List<Company> getAllCompanies() {
	        try {
	            return companyService.getAllCompanies();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    @GetMapping("/{name}")
	    public Company getCompanyByName(@PathVariable(value = "name") String name) {
	        try {
	            return companyService.getCompanyByName(name);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    @PostMapping("")
	    public Company saveCompany(@RequestBody Company company) {
	        try {
	            return companyService.saveCompany(company);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    @DeleteMapping("{name}")
	    public void deleteCompanyById(@PathVariable(value = "name") String name) {
	        
	            companyService.deleteCompanyByName(name);
	       
	    }

}
