package dao.dbmodel;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentDto {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "university")
	private String university;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<ApplicationDto> applications;
	
	public StudentDto() {}
	
	public StudentDto(Long studentId, String username, String password, String name, int age, String email,
			String university, Set<ApplicationDto> applications) {
		
		this.setStudentId(studentId);
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.setAge(age);
		this.setEmail(email);
		this.setUniversity(university);
		this.setApplications(applications);
		
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Set<ApplicationDto> getApplications() {
		return applications;
	}

	public void setApplications(Set<ApplicationDto> applications) {
		this.applications = applications;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
