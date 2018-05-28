package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dao.dbmodel.CompanyDto;
import dao.dbmodel.InternshipDto;

@Repository
@Transactional
public interface IInternshipRepository extends JpaRepository<InternshipDto, Long>{

	public InternshipDto findByName(String name);
	
	public List<InternshipDto> findAllByCompany(CompanyDto company);
	
	public void deleteByName(String name);
	
}
