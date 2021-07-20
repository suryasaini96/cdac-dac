package pojos;

import java.util.Date;

import javax.persistence.*;


/*
 * id(inherited from BaseEntity) , type(enum:SAVING,CURRENT,FD,DMAT,LOAN), balance , transactionDate (Date) --use @Temporal annotation (refer to JPA docs)
 */
@Entity
@Table(name="bank_accts")
public class BankAccount extends BaseEntity{
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private AcctType type;
	private double balance;
	@Temporal(TemporalType.DATE)//by default , it chooses TIMESTAMP
	@Column(name = "transaction_date")
	private Date transactionDate;
	//many to one , bi dir association
	//many side , child , owning side
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor acctOwner;
	public BankAccount() {
		System.out.println("in bank acct ctor");
	}
	public BankAccount(AcctType type, double balance, Date transactionDate) {
		super();
		this.type = type;
		this.balance = balance;
		this.transactionDate = transactionDate;
	}
	public AcctType getType() {
		return type;
	}
	public void setType(AcctType type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public Vendor getAcctOwner() {
		return acctOwner;
	}
	public void setAcctOwner(Vendor acctOwner) {
		this.acctOwner = acctOwner;
	}
	@Override
	public String toString() {
		return "BankAccount : acct no "+getId()+" [type=" + type + ", balance=" + balance + ", transactionDate=" + transactionDate + "]";
	}
	

}
