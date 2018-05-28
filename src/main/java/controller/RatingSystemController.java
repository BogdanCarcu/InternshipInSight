package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Application;
import service.ApplicationService;

@RestController
@RequestMapping("rating")
public class RatingSystemController {

	 private final ApplicationService applicationService;
	 
	 @Autowired
	 public RatingSystemController(ApplicationService applicationService) {
	        this.applicationService = applicationService;
	 }
	 
	 @PostMapping("")
	 public String rate(@RequestParam(required = true) String student,
				  @RequestParam(required = true) String internship,
				  @RequestParam(required = true) float rating,
				  @RequestParam(required = true) String impression) {
			
	        Application a = applicationService.rate(student, internship, rating, impression);
			
			if(a != null)
				return "Rated!";
			
			return "Rating failed!";
			
		}
	 
	
}
