package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	 
		@PostMapping("/acceptance")
	  	public String accept(@RequestParam(required = true) String student,
				  @RequestParam(required = true) String internship) {
			
			Application a = applicationService.accept(student, internship);
			
			if(a != null)
				return "Accepted!";
			
			return "Rejected!";
			
		}
		
		@PostMapping("/info")
	  	public String inform(@RequestParam(required = true) String internship) {
		
			try {
				applicationService.inform(internship);
				return "Applicants were informed";
		
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			return "Failed operation!";
		}
		
	 
}
