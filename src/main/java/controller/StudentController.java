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

import model.Student;
import service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	 private final StudentService studentService;

	    @Autowired
	    public StudentController(StudentService studentService) {
	        this.studentService = studentService;
	    }
	    
	    
	    @GetMapping("")
	    public List<Student> getAllStudents() {
	        try {
	            return studentService.getAllStudents();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    @GetMapping("/{name}")
	    public Student getStudentByName(@PathVariable(value = "name") String name) {
	        try {
	            return studentService.getStudentByName(name);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    @PostMapping("")
	    public Student saveStudent(@RequestBody Student student) {
	        try {
	            return studentService.saveStudent(student);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    @DeleteMapping("{name}")
	    public void deleteStudentById(@PathVariable(value = "name") String name) {
	        
	            studentService.deleteStudentByName(name);
	       
	    }
	
}
