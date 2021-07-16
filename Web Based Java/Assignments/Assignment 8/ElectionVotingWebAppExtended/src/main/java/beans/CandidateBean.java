package beans;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.CandidateDaoImpl;
import dao.ICandidateDao;

public class CandidateBean {
	private String name;
	private String party;
	private String dob;
	private String message;
	
	private ICandidateDao candidateDao;
	
	public CandidateBean() throws SQLException {
		candidateDao = new CandidateDaoImpl();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ICandidateDao getCandidateDao() {
		return candidateDao;
	}

	public void setCandidateDao(ICandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}
	
	public String validateAge() throws SQLException {
		LocalDate dob = LocalDate.parse(this.dob);	
		int age = Period.between(dob, LocalDate.now()).getYears();
		if (age>35) {
			System.out.println("Registration successful");
			message = candidateDao.registerCandidate(name, party);
		} else {
			System.out.println("Registration failed");
			message = "Age should be greater than 35";
		}
		return "admin_page";
	}
	
	
	
	
}
