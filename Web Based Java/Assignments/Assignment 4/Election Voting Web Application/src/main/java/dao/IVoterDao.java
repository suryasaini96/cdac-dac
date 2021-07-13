package dao;

import java.sql.SQLException;

import pojos.Voter;

public interface IVoterDao {
	Voter authenticateVoter(String email, String password) throws SQLException;
	boolean updateStatus(int voterId) throws SQLException;
	void cleanUp() throws SQLException;
}
