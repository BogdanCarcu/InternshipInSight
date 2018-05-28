package service;

import java.util.List;

import model.Company;

public interface CompanyService {

	Company saveCompany(Company company);
	
	List<Company> getAllCompanies();
	
	Company getCompanyByName(String name);
	
	Company getCompanyByUsernameAndPassword(String username, String password);
	
	void deleteCompanyByName(String name);
	
}
