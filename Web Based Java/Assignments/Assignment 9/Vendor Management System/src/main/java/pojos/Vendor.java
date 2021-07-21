package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="vendor")
public class Vendor extends BaseEntity {
	@Column(length = 20)
	private String name;
	@Column(length = 20, unique = true)
	private String email;
	@Column(length = 20)
	private String password;
	@Column(name = "reg_amount")
	private double regAmount;
	@Column(name = "reg_date")
	private LocalDate regDate;
	@OneToMany(mappedBy = "acc_owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BankAccount> accounts = new ArrayList<>();
	
	public Vendor() {
		super();
	}

	public Vendor(String name, String email, String password, double regAmount, LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
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
	
	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(BankAccount acc) {
		accounts.add(acc);
	}

	@Override
	public String toString() {
		return "Vendor [id=" + super.getId() + ", name=" + name + ", email=" + email + ", password=" + password + ", regAmount="
				+ regAmount + ", regDate=" + regDate + "]";
	}
	
}
