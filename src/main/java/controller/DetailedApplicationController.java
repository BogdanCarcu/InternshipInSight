package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.DetailedApplication;
import service.ApplicationService;

@RestController
@RequestMapping("detailedapplication")
public class DetailedApplicationController {
	
	private final ApplicationService appService;
	
	@Autowired
	public DetailedApplicationController(ApplicationService appService) {
		
		this.appService = appService;
		
	}
	
	 @GetMapping("{name}")
	 public List<DetailedApplication> getAll(@PathVariable(value = "name") String company) {
	   
		 return appService.getAll(company);
			 
	  }
	

}
