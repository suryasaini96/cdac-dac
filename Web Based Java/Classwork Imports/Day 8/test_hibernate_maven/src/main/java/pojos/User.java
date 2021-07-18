package pojos;

import java.time.LocalDate;
import javax.persistence.*;

/*
 * Add these Data members
 userId (PK) ,name,email,password,role(enum),confirmPassword, regAmount: subscription amount;
	 LocalDate/Date regDate;
	 byte[] image;
 */
@Entity // mandatory cls level annotation
@Table(name = "user_details")
public class User {
	private Integer userId;// int data type also works only with added autoboxing n upcasting conversions
//int ---> Integer ---> Serializable
	private String name, email, password, confirmPassword;
	private Role userRole;
	private double regAmount;
	private LocalDate regDate;
	private byte[] image;

	public User() {
		System.out.println("in user ctor");
	}

	public User(String name, String email, String password, String confirmPassword, Role userRole, double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	// all setters n getters
	@Id // mandatory at property level(getter) => PK constraint
	// @GeneratedValue//=> automatic id generation
	@GeneratedValue(strategy = GenerationType.IDENTITY) // => automatic id generation : auto_increment
	@Column(name="user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", userRole=" + userRole
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

}
