package dao.dbmodel;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "application")
public class ApplicationDto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "application_id")
	private Long applicationId;
	
    @ManyToOne
    @JoinColumn(name = "student_id")
	private StudentDto student;
	
    @ManyToOne
    @JoinColumn(name = "internship_id")
	private InternshipDto internship;
    
    @Column(name = "cv")
    private Blob cv;
    
    @Column(name = "is_accepted")
    private boolean isAccepted;
	
	@Column(name = "rating")
	private float rating;
	
	@Column(name = "impression")
	private String impression;
	
	public ApplicationDto() {}
	
	public ApplicationDto( Long applicationId, StudentDto student, InternshipDto internship, Blob cv, boolean isAccepted,
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

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	public InternshipDto getInternship() {
		return internship;
	}

	public void setInternship(InternshipDto internship) {
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
		
		if(rating < 0)
			this.rating = 0;
		else if(rating > 10)
			this.rating = 10;
		else
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
