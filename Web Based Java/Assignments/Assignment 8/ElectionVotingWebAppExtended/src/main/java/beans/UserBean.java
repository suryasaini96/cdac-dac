package beans;

import java.sql.SQLException;

import dao.IVoterDao;
import dao.VoterDaoImpl;
import pojos.Voter;

public class UserBean {
	private String email;
	private String password;
	private IVoterDao voterDao;
	private Voter voter;
	
	public UserBean() throws SQLException {
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

	public IVoterDao getVoterDao() {
		return voterDao;
	}

	public void setVoterDao(IVoterDao voterDao) {
		this.voterDao = voterDao;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	
	public String validateUser() throws SQLException {
		voter = voterDao.authenticateVoter(email, password);
		if (voter!=null) {
			if(voter.getRole().equals("admin"))
				return "admin_page";
			if(voter.getStatus()==0)
				return "voter_status";
			return "candidate_list";
		}
		return "login";
	}
	
}
