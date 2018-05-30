package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IApplicationRepository;
import dao.ICompanyRepository;
import dao.IInternshipRepository;
import dao.IStudentRepository;
import dao.dbmodel.ApplicationDto;
import dao.dbmodel.CompanyDto;
import dao.dbmodel.InternshipDto;
import dao.dbmodel.StudentDto;
import model.Internship;
import model.map.DtoToInternship;
import model.map.InternshipToDto;
import service.InternshipService;

@Service
public class InternshipServiceImpl implements InternshipService{
	
	private final IInternshipRepository intRepository;
	private final ICompanyRepository companyRepository;
	private final IStudentRepository studentRepository;
	private final IApplicationRepository appRepository;
	private ModelMapper myMapper;
	
	@Autowired
	public InternshipServiceImpl(IInternshipRepository intRepository,  ICompanyRepository companyRepository,
			IStudentRepository studentRepository, IApplicationRepository appRepository) {
	        this.intRepository = intRepository;
	        this.companyRepository = companyRepository;
	        this.studentRepository = studentRepository;
	        this.appRepository = appRepository;
	        myMapper = new ModelMapper();
	        myMapper.addMappings(new InternshipToDto());
	        myMapper.addMappings(new DtoToInternship());
	}

	@Override
	public Internship saveInternship(Internship internship) {
		
		InternshipDto intDto = myMapper.map(internship, InternshipDto.class);
		CompanyDto company = companyRepository.findByUsername(internship.getCompany());
		
		intDto.setCompany(company);
		
		InternshipDto response = intRepository.save(intDto);
		
		if(response != null)
			return myMapper.map(response, Internship.class);
		else
			return null;
		
	}

	@Override
	public List<Internship> getAllInternships() {
		
		List<InternshipDto> students = intRepository.findAll();
    	List<Internship> result = new ArrayList<Internship>();
    	
    	for(InternshipDto s: students) {
			
    		Internship ns = myMapper.map(s, Internship.class);
			result.add(ns);
			
		}
    	
        return result;
		
	}

	@Override
	public List<Internship> getAllInternshipsByCompany(String companyName) {
		
		CompanyDto companyDto = companyRepository.findByName(companyName);
		
		List<InternshipDto> students = intRepository.findAllByCompany(companyDto);
    	List<Internship> result = new ArrayList<Internship>();
    	
    	for(InternshipDto s: students) {
			
    		Internship ns = myMapper.map(s, Internship.class);
			result.add(ns);
			
		}
    	
        return result;
	}

	@Override
	public Internship getInternshipByName(String name) {
		
		InternshipDto response = intRepository.findByName(name);
		
		if(response != null)
			return myMapper.map(response, Internship.class);
		else
			return null;
	}

	@Override
	public void deleteInternshipByName(String name) {
		
		intRepository.deleteByName(name);
		
	}

	@Override
	public Internship update(Internship internship) {
		
		InternshipDto found = intRepository.findByName(internship.getName());
		InternshipDto toUpdate = myMapper.map(internship, InternshipDto.class);
		
		if(found != null) {
			
			InternshipDto response = intRepository.save(toUpdate);
			
			if(response != null)
				return myMapper.map(response, Internship.class);
			
			return null;
			
		}
		
		return null;
	}

	@Override
	public List<Internship> getAllInternshipsWithNoApplicantNamed(String username) {
		
		StudentDto stud = studentRepository.findByUsername(username);
		List<InternshipDto> internships = intRepository.findAll();
		List<Internship> result = new ArrayList<Internship>();
		
		for(InternshipDto i : internships) {
			
			boolean applied = false;
			List<ApplicationDto> applications = appRepository.findAllByInternship(i);
			
			for(ApplicationDto a : applications) {
				
				if(a.getStudent().getStudentId() == stud.getStudentId()) {
					
					applied = true;
					
				}
				
			}
			
			if(!applied)
				result.add(myMapper.map(i, Internship.class));
			
		}
		
    	
        return result;
	}

}
