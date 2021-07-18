package beans;

import java.sql.SQLException;

import dao.VoterDaoImpl;
import pojos.Voter;

public class UserBean {

	private String email;
	private String password;
	private VoterDaoImpl voterDao;
	private Voter validUserDetails;
	
	//default constructor
	public UserBean() throws Exception {
		System.out.println("In user bean constr....");
		//create dao instance
		voterDao = new VoterDaoImpl();
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

	public VoterDaoImpl getVoterDao() {
		return voterDao;
	}

	public void setVoterDao(VoterDaoImpl voterDao) {
		this.voterDao = voterDao;
	}

	public Voter getValidUserDetails() {
		return validUserDetails;
	}

	public void setValidUserDetails(Voter validUserDetails) {
		this.validUserDetails = validUserDetails;
	}

	
	//BUSINESS LOGIC 
	//rules : methods should be public as JSP is going to call this methods
	//no need of method argument here bcoz from JSP we are saying jsp:setProperty, so email and pass will come automatically
 	public String validateUser() throws SQLException {
		System.out.println("In validate user : "+email+","+password);
		//invoke dao's method for user authentication
		validUserDetails = voterDao.authenticateVoter(email, password);
		if(validUserDetails != null) {
			//login success
			//check the role
			if(validUserDetails.getRole().equals("admin")) 
				return "admin_page";
			//voter role
			if(validUserDetails.getStatus())
				return "voter_status";
			//not yet voted
			return "candidate_list";
		}
		//invalid login
		return "login";
	}

	
}
