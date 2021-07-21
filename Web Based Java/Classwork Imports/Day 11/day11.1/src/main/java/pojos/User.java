package pojos;
/*
 *  userId (PK) ,name,email,password,role(enum),confirmPassword, regAmount;
	 LocalDate/Date regDate;
	 byte[] image;
 */

import java.time.LocalDate;
import javax.persistence.*;

@Entity //mandatory
@Table(name = "users_tbl")
public class User {
	@Id//mandatory : PK constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto id generation + constraint : auto_incr
	@Column(name = "user_id")
	private Integer userId;
	@Column(length = 20) //varchar(20)
	private String name;
	@Column(length = 20,unique = true) //varchar(20) , UNIQUE constraint
	private String email;
	@Column(length = 20)
	private String password;
	@Enumerated(EnumType.STRING) //col type varchar(20) : enum name
	@Column(length = 20)
	private Role role;
	@Transient //skip from persistence (no col generation)
	private String confirmPassword;
	@Column(name="reg_amount")
	private double regAmount;
	@Column(name="reg_date")
	private LocalDate regDate;
	@Lob //medium blob????
	private byte[] image;
	public User() {
		System.out.println("in user ctor");
	}
	public User(String name, String email, String password, Role role, String confirmPassword, double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.confirmPassword = confirmPassword;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	
	public User(Integer userId, String email, double regAmount, LocalDate regDate) {
		super();
		this.userId = userId;
		this.email = email;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	//ALL setters n getters
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
		System.out.println("in set name");
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", confirmPassword=" + confirmPassword + ", regAmount=" + regAmount + ", regDate=" + regDate
				+ "]";
	}
	
	
	
	

}
