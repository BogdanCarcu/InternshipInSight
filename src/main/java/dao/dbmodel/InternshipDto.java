package dao.dbmodel;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "internship")
public class InternshipDto {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "internship_id")
	private Long internshipId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", nullable = false)
	private CompanyDto company; 
	
	@OneToMany(mappedBy = "internship", cascade = CascadeType.ALL)
	private Set<ApplicationDto> applications;
	
	public InternshipDto() {}
	
	public InternshipDto(Long internshipId, String name, Date date, int duration, String description, CompanyDto company,
						Set<ApplicationDto> applications) {
		
		this.setInternshipId(internshipId);
		this.setName(name);
		this.setDate(date);
		this.setDuration(duration);
		this.setDescription(description);
		this.setCompany(company);
		this.setApplications(applications);
		
	}

	public Long getInternshipId() {
		return internshipId;
	}

	public void setInternshipId(Long internshipId) {
		this.internshipId = internshipId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}

	public Set<ApplicationDto> getApplications() {
		return applications;
	}

	public void setApplications(Set<ApplicationDto> applications) {
		this.applications = applications;
	}
	
	
}
