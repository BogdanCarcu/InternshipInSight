package model;


public class Company implements IUser{

	private Long companyId;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private int numberOfEmployees;
	
	public Company() {}
	
	public Company(Long companyId, String username, String password,
			String name, int numberOfEmployees) {
		
		this.setCompanyId(companyId);
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.setNumberOfEmployees(numberOfEmployees);
	
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


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
