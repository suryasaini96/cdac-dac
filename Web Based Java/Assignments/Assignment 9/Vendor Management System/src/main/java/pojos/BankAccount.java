package pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BaseEntity {
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private AccType type;
	private double balance;
	@Temporal(TemporalType.DATE)
	@Column(name = "tx_date")
	private Date tx_date;
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor accOwner;
	
	public BankAccount() {
		System.out.println("Bank account ctor");
	}

	public BankAccount(AccType type, double balance, Date tx_date) {
		super();
		this.type = type;
		this.balance = balance;
		this.tx_date = tx_date;
	}

	public AccType getType() {
		return type;
	}

	public void setType(AccType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getTx_date() {
		return tx_date;
	}

	public void setTx_date(Date tx_date) {
		this.tx_date = tx_date;
	}

	public Vendor getAccOwner() {
		return accOwner;
	}

	public void setAccOwner(Vendor accOwner) {
		this.accOwner = accOwner;
	}

	@Override
	public String toString() {
		return "BankAccount [accNo=" + getId() + " type=" + type + ", balance=" + balance + ", tx_date=" + tx_date + ", accOwner=" + accOwner
				+ "]";
	}

}
