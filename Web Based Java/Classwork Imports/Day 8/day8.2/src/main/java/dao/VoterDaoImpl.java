package dao;

import java.sql.*;
import static utils.DBUtils.fetchConnection;

import pojos.Voter;

public class VoterDaoImpl implements IVoterDao {
	private Connection cn;
	private PreparedStatement pst1,pst2;

	public VoterDaoImpl() throws Exception {
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from voters where email=? and password=?");
		pst2=cn.prepareStatement("update voters set status=? where id=?");
		System.out.println("voter dao created ....");
	}

	@Override
	public Voter authenticateVoter(String email, String pass) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pass);
		System.out.println("voter dao : exec auth query");
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voter(rst.getInt(1), rst.getString(2), email, pass, rst.getBoolean(5), rst.getString(6));
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		
		System.out.println("voter dao cleaned");
	}

	@Override
	public String updateVotingStatus(int voterId) throws SQLException {
		// set IN param : status , voter ID
		pst2.setBoolean(1, true);
		pst2.setInt(2, voterId);
		int updateCount=pst2.executeUpdate();
		if(updateCount == 1)
			return "Voting status updated";
		return "Voting failed!!!!!!";
	}
	

}
