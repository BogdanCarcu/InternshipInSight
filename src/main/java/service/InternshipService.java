package service;

import java.util.List;

import model.Internship;

public interface InternshipService {
	
	Internship saveInternship(Internship internship);
	
	List<Internship> getAllInternships();
	
	List<Internship> getAllInternshipsByCompany(String companyName);
	
	Internship getInternshipByName(String name);
	
	void deleteInternshipByName(String name);
	
	Internship update(Internship internship);

}
