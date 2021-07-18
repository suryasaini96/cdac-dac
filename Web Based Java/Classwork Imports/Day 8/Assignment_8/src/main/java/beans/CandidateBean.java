package beans;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateBean {
	private String name;
	private String party;
	private String dob;
	private String msg;
	
	private CandidateDaoImpl candidateDao;
	private Candidate validCandidate;

	public CandidateBean() throws Exception {
		System.out.println("In candidateBean constr...");
		candidateDao = new CandidateDaoImpl();
	}

	
	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
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

	public CandidateDaoImpl getCandidateDao() {
		return candidateDao;
	}

	public void setCandidateDao(CandidateDaoImpl candidateDao) {
		this.candidateDao = candidateDao;
	}

	// BUSINESS LOGIC : keep method public(accessible to JSP)
	public String validateAge() throws SQLException {

		System.out.println("Inside validateAge : " + name + "," + party + "," + dob);

		LocalDate d1 = LocalDate.parse(dob);
		Period period = Period.between(d1, LocalDate.now());
		int age = period.getYears();
		if (age > 35) {
			System.out.println("Reg success...");
			msg = candidateDao.registerCandidate(name, party);
			return "admin_page";
		} else {
			System.out.println("Reg failed....");
			msg = "Registration Failed (Age should be greater than 35)";
			return "admin_page";
		}
	}

}
