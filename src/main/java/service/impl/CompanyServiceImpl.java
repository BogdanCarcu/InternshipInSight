package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ICompanyRepository;
import model.Company;
import service.CompanyService;
import dao.dbmodel.CompanyDto;

@Service
public class CompanyServiceImpl implements CompanyService{

	private ICompanyRepository companyRepository;
	private ModelMapper myMapper;
	
	@Autowired
	public CompanyServiceImpl(ICompanyRepository companyRepository) {
	        this.companyRepository = companyRepository;
	        myMapper = new ModelMapper();
	   
	}
	
	@Override
	public Company saveCompany(Company company) {
		
		CompanyDto companyDto = myMapper.map(company, CompanyDto.class);
		CompanyDto response = companyRepository.save(companyDto);
		
		if(response != null)
			return myMapper.map(response, Company.class);
		else
			return null;
		
	}

	@Override
	public List<Company> getAllCompanies() {
		
		List<CompanyDto> companies = companyRepository.findAll();
    	List<Company> result = new ArrayList<Company>();
    	
    	for(CompanyDto c: companies) {
			
			Company cc = myMapper.map(c, Company.class);
			result.add(cc);
			
		}
    	
        return result;
	}

	@Override
	public Company getCompanyByName(String name) {
		CompanyDto response = companyRepository.findByName(name);
		
		if(response != null)
			return myMapper.map(response, Company.class);
		else
			return null;
		
	}

	@Override
	public void deleteCompanyByName(String name) {
		
		companyRepository.deleteByName(name);
		
	}

	@Override
	public Company getCompanyByUsernameAndPassword(String username, String password) {
		
		CompanyDto companyDto = companyRepository.findByUsernameAndPassword(username, password);
		if(companyDto != null)
			return myMapper.map(companyDto, Company.class);
		
		return null;
		
	}

	@Override
	public Company getCompanyByUsername(String username) {
		CompanyDto response = companyRepository.findByUsername(username);
		
		if(response != null)
			return myMapper.map(response, Company.class);
		else
			return null;
	}
	

}
