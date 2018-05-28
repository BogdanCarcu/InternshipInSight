package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IStudentRepository;
import dao.dbmodel.StudentDto;
import model.Student;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private final IStudentRepository studentRepository;
	private ModelMapper myMapper;
	
	@Autowired
	public StudentServiceImpl(IStudentRepository studentRepository) {
	        this.studentRepository = studentRepository;
	        myMapper = new ModelMapper();
	}

	@Override
	public Student saveStudent(Student student) {
		
		StudentDto studentDto = myMapper.map(student, StudentDto.class);
		StudentDto response = studentRepository.save(studentDto);
		
		if(response != null)
			return myMapper.map(response, Student.class);
		else
			return null;
		
	}

	@Override
	public List<Student> getAllStudents() {
		
		List<StudentDto> students = studentRepository.findAll();
    	List<Student> result = new ArrayList<Student>();
    	
    	for(StudentDto s: students) {
			
			Student ns = myMapper.map(s, Student.class);
			result.add(ns);
			
		}
    	
        return result;
		
	}

	@Override
	public Student getStudentByName(String name) {
		
		StudentDto response = studentRepository.findByName(name);
		
		if(response != null)
			return myMapper.map(response, Student.class);
		else
			return null;
		
	}

	@Override
	public void deleteStudentByName(String name) {
		
		studentRepository.deleteByName(name);
		
	}

	@Override
	public Student getStudentByUsernameAndPassword(String username, String password) {
		
		StudentDto studentDto = studentRepository.findByUsernameAndPassword(username, password);
		if(studentDto != null)
			return myMapper.map(studentDto, Student.class);
		
		return null;
		
	}

}
