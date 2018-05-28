package model;

public class Student implements IUser{

	private Long studentId;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private int age;
	
	private String email;
	
	private String university;
	
	public Student() {}
	
	public Student(Long studentId, String username, String password, String name, int age, String email,
			String university) {
		
		this.setStudentId(studentId);
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.setAge(age);
		this.setEmail(email);
		this.setUniversity(university);
		
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
