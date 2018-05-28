package service;

import java.sql.Blob;
import java.util.List;

import model.Application;

public interface ApplicationService {
	
	Application findApplication(String student, String internship);
	
	Application apply(String student, String internship, Blob cv); //create
	
	Application accept(String student, String internship); //update for boolean field isAccepted
	
	Application rate(String student, String internship, float rate, String impression); //update for rating and impression
	
	void inform(String internship); //inform the rejected and accepted students about their success/failure 
	
	List<Application> findAllAplicationsForInternship(String internship);
	
}
