package pojos;
//name (string) , email  (string : unique) , password(string) : NOT NULL  ,regAmount (double) , regDate (LocalDate)

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="vendor_tbl")
public class Vendor extends BaseEntity {
	@Column(length = 30)
	private String name;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 20,nullable = false)
	private String password;
	@Column(name="reg_amount")
	private double regAmount;
	@Column(name="reg_date")
	private LocalDate regDate;
	//one to many , bi dir asso between Vendor 1 <----->* BankAccount
	//Vendor : one , parent , inverse
	@OneToMany(mappedBy = "acctOwner",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<BankAccount> accounts=new ArrayList<>();
	
	public Vendor() {
		// TODO Auto-generated constructor stub
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
	//convenience / helper method : add / remove
	public void addAccount(BankAccount acct)
	{
		//vendor ---> bank acct
		accounts.add(acct);
		//bank acct ---> vendor
		acct.setAcctOwner(this);
		
	}
	public void removeAccount(BankAccount acct)
	{
		//vendor --X-> bank acct
		accounts.remove(acct);
		//bank acct --X-> vendor
		acct.setAcctOwner(null);
	}

	@Override
	public String toString() {
		return "Vendor [name=" + name + ", email=" + email + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}
	
	

}
