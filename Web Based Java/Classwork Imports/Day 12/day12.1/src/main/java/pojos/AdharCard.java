package pojos;
//card number , creation date , location

import java.time.LocalDate;
import javax.persistence.*;

@Embeddable //to tell hibernate , whatever follows is a Composite value type , which will be embedded 
//in the owning entity
public class AdharCard {
	@Column(length = 30,name="card_number",unique = true)
	private String cardNumber;
	@Column(name="creation_date")
	private LocalDate creationDate;
	@Column(length = 30)
	private String location;
	public AdharCard() {
		// TODO Auto-generated constructor stub
	}
	public AdharCard(String cardNumber, LocalDate creationDate, String location) {
		super();
		this.cardNumber = cardNumber;
		this.creationDate = creationDate;
		this.location = location;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "AdharCard [cardNumber=" + cardNumber + ", creationDate=" + creationDate + ", location=" + location
				+ "]";
	}
	
	

}
