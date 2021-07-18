package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.DBUtils.fetchConnection;

import pojos.Voter;

public class VoterDaoImpl implements IVoterDao {

	private Connection cn;
	private PreparedStatement pstAuthenticate;
	private PreparedStatement pstUpdateVotingStatus;

	public VoterDaoImpl() throws SQLException, ClassNotFoundException {

		// get connection from DBUtils
		cn = fetchConnection();

		// create pre parsed pre compiled statement for dynamic and repetative queries
		pstAuthenticate = cn.prepareStatement("select * from voters where email=? and password=?");
		pstUpdateVotingStatus = cn.prepareStatement("update voters set status=? where id=?");

		System.out.println("VoterDaoImpl constructor...");

	}

	@Override
	public Voter authenticateVoter(String email, String password) throws SQLException {

		System.out.println("Voter dao : authenticateVoter");
		// set IN parameters
		pstAuthenticate.setString(1, email);
		pstAuthenticate.setString(2, password);

		try (ResultSet rst = pstAuthenticate.executeQuery()) {

			if (rst.next()) {
				return new Voter(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getBoolean(5),
						rst.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateVotingStatus(int voterId) throws SQLException {

		pstUpdateVotingStatus.setBoolean(1, true);
		pstUpdateVotingStatus.setInt(2, voterId);

		int statusCount = pstUpdateVotingStatus.executeUpdate();

		if (statusCount == 1)
			System.out.println("Status updated....");
		else
			System.out.println("Status doesn't updated...");
	}

	public void cleanUp() throws SQLException {
		if (pstAuthenticate != null)
			pstAuthenticate.close();

		if (pstUpdateVotingStatus != null)
			pstUpdateVotingStatus.close();

		System.out.println("Voter DAO cleaned up...");

	}

}
