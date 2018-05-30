package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Application;
import service.ApplicationService;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

 private final ApplicationService applicationService;
	 
	 @Autowired
	 public FeedbackController(ApplicationService applicationService) {
	        this.applicationService = applicationService;
	 }
	 
		@PutMapping("/acceptance")
	  	public String accept(@RequestParam(required = true) String student,
				  @RequestParam(required = true) String internship) {
			
			Application a = applicationService.accept(student, internship);
			
			if(a != null)
				return "Accepted!";
			
			return "Rejected!";
			
		}
		
		@PostMapping("/info")
	  	public boolean inform(@RequestParam(required = true) String internship) {
		
			try {
				applicationService.inform(internship);
				return true;
		
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			return false;
		}
		
	 
}
