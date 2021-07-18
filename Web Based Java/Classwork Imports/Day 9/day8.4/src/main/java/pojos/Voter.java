package pojos;

public class Voter {
//id | name email   | password | status | role
	private int voterId;
	private String name,email,password;
	private boolean status;
	private String role;
	public Voter() {
		// TODO Auto-generated constructor stub
	}
	public Voter(int voterId, String name,String email, String password, boolean status, String role) {
		super();
		
		this.voterId = voterId;
		this.name=name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}
	public int getVoterId() {
		return voterId;
	}
	public void setVoterId(int voterId) {
		this.voterId = voterId;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", name=" + name + ", email=" + email + ", status=" + status + ", role="
				+ role + "]";
	}
	
	
}
