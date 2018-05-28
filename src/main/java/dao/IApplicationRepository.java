package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dao.dbmodel.ApplicationDto;
import dao.dbmodel.InternshipDto;
import dao.dbmodel.StudentDto;

@Repository
@Transactional
public interface IApplicationRepository extends JpaRepository<ApplicationDto, Long> {

	ApplicationDto findByStudentAndInternship(StudentDto student, InternshipDto internship);
	
	List<ApplicationDto> findAllByInternship(InternshipDto internship);
	
	List<ApplicationDto> findAllByStudent(StudentDto student);
	
}
