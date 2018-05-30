package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Student;
import service.StudentService;

@RestController
@RequestMapping("studentregistration")
public class StudentRegistrationController {

	 private final StudentService studentService;

	    @Autowired
	    public StudentRegistrationController(StudentService studentService) {
	        this.studentService = studentService;
	    }

	    @PostMapping("")
	    public String registerStudent(@RequestBody Student student) {
	        try {
	            Student s =  studentService.saveStudent(student);
	            if(s != null)
	            	return "index";
	            
	            return "studentregistration";
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "studentregistration";
	        }
	    }
	    
	    
}
