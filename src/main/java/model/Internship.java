package model;

import java.util.Date;

public class Internship {

	private Long internshipId;
	
	private String name;
	
	private Date date;
	
	private int duration;
	
	private String description;
	
	private String company; 

	
	public Internship() {}
	
	public Internship(Long internshipId, String name, Date date, int duration, String description, String company) {
		
		this.setInternshipId(internshipId);
		this.setName(name);
		this.setDate(date);
		this.setDuration(duration);
		this.setDescription(description);
		this.setCompany(company);
		
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


}
