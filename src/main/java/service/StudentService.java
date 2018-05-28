package service;

import java.util.List;

import model.Student;

public interface StudentService {

	Student saveStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student getStudentByName(String name);
	
	Student getStudentByUsernameAndPassword(String username, String password);
	
	void deleteStudentByName(String name);
	
}
