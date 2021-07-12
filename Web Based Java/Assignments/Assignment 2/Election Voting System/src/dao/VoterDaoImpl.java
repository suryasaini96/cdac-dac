package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.Voter;
import static utils.DBUtils.*;

public class VoterDaoImpl implements IVoterDao{
	
	private Connection conn;
	private PreparedStatement psAuth;
	private PreparedStatement psGetStatus;
	private PreparedStatement psUpdateStatus;
	
	public VoterDaoImpl() throws SQLException {
		conn = fetchConnection();
		psAuth = conn.prepareStatement("select * from voters where email=? and password=?");
		psGetStatus = conn.prepareStatement("select status from voters where id=?");
		psUpdateStatus = conn.prepareStatement("update voters set status=1 where id=?");
	}

	@Override
	public Voter authenticateVoter(String email, String password) throws SQLException {
		psAuth.setString(1, email);
		psAuth.setString(2, password);
		ResultSet rs = psAuth.executeQuery();
		rs.next();
		return new Voter(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
	}
	
	@Override
	public boolean updateStatus(int id) throws SQLException {
		// Check if user has already voted
		psGetStatus.setInt(1, id);
		ResultSet rs = psGetStatus.executeQuery();
		rs.next();
		int status = rs.getInt(1);
		if (status==1) {
			System.out.println("You have already voted!");
			return false;
		}
			
		// If not voted then update status
		psUpdateStatus.setInt(1, id);
		int count = psUpdateStatus.executeUpdate();
		if (count>0) 
			return true;
		return false;
	}
	
	public void cleanUp() throws SQLException {
		if(psAuth!=null)
			psAuth.close();
		if(psGetStatus!=null)
			psGetStatus.close();
		if(psUpdateStatus!=null)
			psUpdateStatus.close();
		if(conn!=null)
			conn.close();
	}
}
