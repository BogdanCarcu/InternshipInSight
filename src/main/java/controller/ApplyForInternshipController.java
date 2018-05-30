package controller;


import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import service.ApplicationService;


@RestController
@RequestMapping("application")
public class ApplyForInternshipController {
	
	 private final ApplicationService applicationService;
	 
	 @Autowired
	 public ApplyForInternshipController(ApplicationService applicationService) {
	        this.applicationService = applicationService;
	 }
	 
	  
	  	@PostMapping("")
	  	public String apply(@RequestParam(required = true) String student,
				  @RequestParam(required = true) String internship,
				  @RequestParam("file") MultipartFile file) {

	        try {

	       
	            byte[] bytes = file.getBytes(); 
	            Blob cv = new SerialBlob(bytes);
	            applicationService.apply(student, internship, cv);
	            
	            
	            return "Success!";

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return "Failed!";
	    }
	  	

}
