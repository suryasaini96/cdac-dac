package beans;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateBean {
	//clnt's conversational state
	private String name;
	private String party;
	private String dob;
	private String message;
	private CandidateDaoImpl candidateDao;
	public CandidateBean() throws Exception {
		System.out.println("in candidate bean constr");
		candidateDao=new CandidateDaoImpl();
	}
	public String getMessage() {
		return message;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public CandidateDaoImpl getCandidateDao() {
		return candidateDao;
	}
	//B.L method for candidate registration
	public String registerCandidate()
	{
		LocalDate dateOfBirth=LocalDate.parse(dob);
		int age =Period.between(dateOfBirth, LocalDate.now()).getYears();
		System.out.println("age="+age);
		if(age > 35)
		{
			try {
				message=candidateDao.registerCandidate(new Candidate(name, party));
				return message;
			} catch (SQLException e) {
				//registration failed
				message="registration failed : "+e.getMessage();
			}
		}
		message="registration failed : Invalid DoB";
		return "admin_page";
		
	}

}
