package model;

import java.sql.Blob;

public class Application {

	private Long applicationId;

	private String student;
	
	private String internship;
    
    private Blob cv;
    
    private boolean isAccepted;

	private float rating;

	private String impression;
	
	public Application() {}
	
	public Application( Long applicationId, String student, String internship, Blob cv, boolean isAccepted,
							float rating,
							String impression) {
		
		this.applicationId = applicationId;
		this.setStudent(student);
		this.setInternship(internship);
		this.setCv(cv);
		this.setAccepted(isAccepted);
		this.setRating(rating);
		this.setImpression(impression);
		
		
	}
	
	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId =  applicationId;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getInternship() {
		return internship;
	}

	public void setInternship(String internship) {
		this.internship = internship;
	}

	public Blob getCv() {
		return cv;
	}

	public void setCv(Blob cv) {
		this.cv = cv;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

}
