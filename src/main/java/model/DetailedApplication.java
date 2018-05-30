package model;

public class DetailedApplication {
	
	private String name;
	
	private int age;
	
	private String email;
	
	private String university;
	
	private String internship;
	
	public DetailedApplication() {}
	
	public DetailedApplication(String name, int age, String email, String university, String internship) {
		
		this.name = name;
		this.age = age;
		this.university = university;
		this.email = email;
		this.internship = internship;
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getInternship() {
		return internship;
	}

	public void setInternship(String internship) {
		this.internship = internship;
	}
	
	

}
