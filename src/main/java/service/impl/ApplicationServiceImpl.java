package service.impl;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import dao.IApplicationRepository;
import dao.IInternshipRepository;
import dao.IStudentRepository;
import dao.dbmodel.ApplicationDto;
import dao.dbmodel.InternshipDto;
import dao.dbmodel.StudentDto;
import model.Application;
import model.map.ApplicationToDto;
import model.map.DtoToApplication;
import service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService{

	private final IInternshipRepository intRepository;
	private final IStudentRepository studentRepository;
	private final IApplicationRepository appRepository;
	
	private ModelMapper myMapper;
	private JavaMailSender sender;
	
	private void sendEmail(String destination, String internship, String text) throws Exception{
	
		       MimeMessage message = sender.createMimeMessage();
		
		       MimeMessageHelper helper = new MimeMessageHelper(message);
		
		       helper.setTo(destination);
		
		       helper.setText(text);
		
		       helper.setSubject("Response for " + internship + " application");
		        
		       sender.send(message);
		    }

	@Autowired
	public ApplicationServiceImpl(IInternshipRepository intRepository, IStudentRepository studentRepository,
			IApplicationRepository appRepository, JavaMailSender sender) {
		
			this.intRepository = intRepository;
			this.studentRepository = studentRepository;
	        this.appRepository = appRepository;
	        this.sender = sender;
	        myMapper = new ModelMapper();
	        myMapper.addMappings(new ApplicationToDto());
	        myMapper.addMappings(new DtoToApplication());
		
	}
	
	@Override
	public Application apply(String student, String internship, Blob cv) {
		
		//save new Application
		StudentDto studentDto = studentRepository.findByName(student);
		InternshipDto internshipDto = intRepository.findByName(internship);
		
		if(appRepository.findByStudentAndInternship(studentDto, internshipDto) == null) {
		
			ApplicationDto app = new ApplicationDto();
			app.setStudent(studentDto);
			app.setInternship(internshipDto);
				
			app.setCv(cv);
				
			ApplicationDto response = appRepository.save(app);
			
			if(response != null)
				return myMapper.map(response, Application.class);
			
			return null;
			
		}
		
		return null;
		
	}

	@Override
	public Application accept(String student, String internship) {
		
		StudentDto studentDto = studentRepository.findByName(student);
		InternshipDto internshipDto = intRepository.findByName(internship);
		ApplicationDto found = appRepository.findByStudentAndInternship(studentDto, internshipDto);
		
		if(found != null) {
		
			found.setAccepted(true);
			
			ApplicationDto response = appRepository.save(found);
			
			if(response != null)
				return myMapper.map(response, Application.class);
			
			return null;
			
		}
		
		return null;
	}

	@Override
	public Application rate(String student, String internship, float rate, String impression) {
		
		StudentDto studentDto = studentRepository.findByName(student);
		InternshipDto internshipDto = intRepository.findByName(internship);
		ApplicationDto found = appRepository.findByStudentAndInternship(studentDto, internshipDto);
		
		if(found != null && found.isAccepted()) {
		
			found.setRating(rate);
			found.setImpression(impression);
			
			ApplicationDto response = appRepository.save(found);
			
			if(response != null)
				return myMapper.map(response, Application.class);
			
			return null;
			
		}
		
		return null;
	}

	@Override
	public void inform(String internship) {
		
		InternshipDto internshipDto = intRepository.findByName(internship);
		List<ApplicationDto> apps = appRepository.findAllByInternship(internshipDto);
		
		for(ApplicationDto a : apps) {
			
			try {
			
				if(a.isAccepted())
					sendEmail(a.getStudent().getEmail(), internship, "Welcome to our team!");
				else
					sendEmail(a.getStudent().getEmail(), internship, "We are sorry! We decided to go on with another candidate :(");
			
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
		}
		
		
	}

	@Override
	public List<Application> findAllAplicationsForInternship(String internship) {
		
		InternshipDto internshipDto = intRepository.findByName(internship);
		List<ApplicationDto> apps = appRepository.findAllByInternship(internshipDto);
		List<Application> applications = new ArrayList<Application>();
		
		for(ApplicationDto a : apps) {
			
			Application temp = myMapper.map(a, Application.class);
			applications.add(temp);
		}
		
		return applications;
	}

	@Override
	public Application findApplication(String student, String internship) {
		
		StudentDto studentDto = studentRepository.findByName(student);
		InternshipDto internshipDto = intRepository.findByName(internship);
		ApplicationDto app = appRepository.findByStudentAndInternship(studentDto, internshipDto);
		
		if(app != null)
			return myMapper.map(app, Application.class);
		
		return null;
		
	}
		

}
