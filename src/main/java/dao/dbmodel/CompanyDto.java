package dao.dbmodel;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyDto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
	private Long companyId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "number_of_employees")
	private int numberOfEmployees;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private Set<InternshipDto> internships;
	
	public CompanyDto() {}
	
	public CompanyDto(Long companyId, String username, String password,
			String name, int numberOfEmployees, Set<InternshipDto> internships) {
		
		this.setCompanyId(companyId);
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.setNumberOfEmployees(numberOfEmployees);
		this.setInternships(internships);
	
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public Set<InternshipDto> getInternships() {
		return internships;
	}

	public void setInternships(Set<InternshipDto> internships) {
		this.internships = internships;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
