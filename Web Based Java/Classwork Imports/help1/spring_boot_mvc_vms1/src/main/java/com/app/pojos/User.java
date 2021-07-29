package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users_tbl")
public class User extends BaseEntity {
	@Column(length = 20)
	private String name="abc";
	@Column(length = 20,unique = true)
	private String email="abc@gmail.com";
	@Column(length = 20,nullable = false)
	private String password;
	@Column(name="reg_amount")
	private double regAmount;
	@Column(name="reg_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate regDate;
	@Enumerated(EnumType.STRING)
	@Column(length = 20,name="user_role")
	private Role role;

	public User() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// ALL setters n getters
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User ID " + getId() + name+" email=" + email + ", regAmount=" + regAmount + ", regDate=" + regDate;
	}

}
