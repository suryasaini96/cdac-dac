package dao;

import java.sql.SQLException;

import pojos.Voter;

public interface IVoterDao {
	//add a method for user validation
	Voter authenticateVoter(String email, String pass) throws SQLException;
	//add a method for updating voting status
	String updateVotingStatus(int voterId)throws SQLException;
	
}
