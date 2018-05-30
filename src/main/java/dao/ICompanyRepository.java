package dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dao.dbmodel.CompanyDto;

@Repository
@Transactional
public interface ICompanyRepository extends JpaRepository<CompanyDto, Long>{

	public CompanyDto findByName(String name);
	
	public CompanyDto findByUsername(String username);
	
	public void deleteByName(String name);
	
	public CompanyDto findByUsernameAndPassword(String username, String password);
	
}
