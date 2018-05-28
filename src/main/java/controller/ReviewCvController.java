package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Application;
import service.ApplicationService;

@RestController
@RequestMapping("cvreview")
public class ReviewCvController {

 private final ApplicationService applicationService;
	 
	 @Autowired
	 public ReviewCvController(ApplicationService applicationService) {
	        this.applicationService = applicationService;
	 }
	 
	 @GetMapping("")
	  public String getCompanyByName(@RequestParam(value = "student") String student, 
	    		@RequestParam(value = "internship") String internship) {
		 
	  try {
	        	Application app = applicationService.findApplication(student, internship);
	        	Blob cv = app.getCv();
	        	
				   BufferedInputStream is = new BufferedInputStream(cv.getBinaryStream());
				   FileOutputStream fos = new FileOutputStream("C:\\CodeBase\\INTERNSHIP_IN_SIGHT\\lel.pdf");
				  
				   // you can set the size of the buffer
				   byte[] buffer = new byte[2048];
				   int r = 0;
				   while((r = is.read(buffer))!=-1) {
				      fos.write(buffer, 0, r);
				   }
				   fos.flush();
				   fos.close();
				   is.close();
				  // cv.free();
				   
				   return "Success!";
	            
	      } catch (Exception e) {
	            e.printStackTrace();
	            return "Failure!";
	      }		
		 
	    }
	
}
