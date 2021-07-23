package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="users_tbl")
public class User extends BaseEntity{
	@Column(length = 20)
	private String name;
	@Column(length = 20,unique =true)
	private String email;
	@Column(length = 20)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name="user_role",length = 20)	
	private Role userRole;
	@Column(name="reg_amount")
	private double regAmount;
	@Column(name="reg_date")
	private LocalDate regDate;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String email, String password, double regAmount, LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	//all setters n getters
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
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", userRole=" + userRole
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}
	
	

}
