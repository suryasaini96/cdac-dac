package beans;

import java.sql.SQLException;

import dao.VoterDaoImpl;
import pojos.Voter;

public class UserBean {
	//properties : non static , non transient private data members
	//clnt's conversational state(req params)
	private String email;
	private String password;
	//manages DAO layer : reference
	private VoterDaoImpl voterDao;
	//validated user details : POJO (Voter)
	private Voter validUserDetails;
	//default constr : invoked by WC (trigger : jsp:useBean)
	public UserBean() throws Exception {
		System.out.println("in user bean constr");
		//create dao instance
		voterDao=new VoterDaoImpl();
		System.out.println("user bean created....");
	}
	//setters n getters
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
	//Add a B.L method for user authentication
	//rules : public 
	public String validateUser() throws SQLException
	{
		System.out.println("in validate user "+email+" "+password);
		//invoke dao's method for user authentication
		validUserDetails=voterDao.authenticateVoter(email, password);
		if(validUserDetails != null)
		{
			//login successful
			//chk role
			if(validUserDetails.getRole().equals("admin"))
				return "admin_page";
			//voter role
			if(validUserDetails.isStatus())
				return "voter_status";
			//not yet voted 
			return "candidate_list";
		}
		//invlaid login
		return "login";
	}
	

}
