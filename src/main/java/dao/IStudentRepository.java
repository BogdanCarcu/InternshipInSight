package dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dao.dbmodel.StudentDto;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<StudentDto, Long>{

	public StudentDto findByName(String name);
	
	public StudentDto findByUsername(String username);
	
	public void deleteByName(String name);
	
	public StudentDto findByUsernameAndPassword(String username, String password);
	
	
}
