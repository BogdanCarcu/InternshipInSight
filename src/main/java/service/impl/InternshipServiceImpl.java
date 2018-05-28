package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ICompanyRepository;
import dao.IInternshipRepository;
import dao.dbmodel.CompanyDto;
import dao.dbmodel.InternshipDto;
import model.Internship;
import model.map.DtoToInternship;
import model.map.InternshipToDto;
import service.InternshipService;

@Service
public class InternshipServiceImpl implements InternshipService{
	

	private final IInternshipRepository intRepository;
	private final ICompanyRepository companyRepository;
	private ModelMapper myMapper;
	
	@Autowired
	public InternshipServiceImpl(IInternshipRepository intRepository,  ICompanyRepository companyRepository) {
	        this.intRepository = intRepository;
	        this.companyRepository = companyRepository;
	        myMapper = new ModelMapper();
	        myMapper.addMappings(new InternshipToDto());
	        myMapper.addMappings(new DtoToInternship());
	}

	@Override
	public Internship saveInternship(Internship internship) {
		
		InternshipDto intDto = myMapper.map(internship, InternshipDto.class);
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

}
