package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Internship;
import service.InternshipService;


@RestController
@RequestMapping("internship")
public class InternshipController {

	private final InternshipService internshipService;

    @Autowired
    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }
    
    
    @GetMapping("")
    public List<Internship> getAllInternships(@RequestParam(required = false) String company,
    		@RequestParam(required = false) String student) {
        try {
        	
        	if(company == null)
        		if(student == null)
        			return internshipService.getAllInternships();
        		else
        			return internshipService.getAllInternshipsWithNoApplicantNamed(student);
        	else
        		return internshipService.getAllInternshipsByCompany(company);
        	
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @GetMapping("/{name}")
    public Internship getInternshipByName(@PathVariable(value = "name") String name) {
        try {
            return internshipService.getInternshipByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @PostMapping("")
    public Internship saveInternship(@RequestBody Internship internship) {
        try {
            return internshipService.saveInternship(internship);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @DeleteMapping("{name}")
    public void deleteInternshipById(@PathVariable(value = "name") String name) {
        
            internshipService.deleteInternshipByName(name);
       
    }
	
}
