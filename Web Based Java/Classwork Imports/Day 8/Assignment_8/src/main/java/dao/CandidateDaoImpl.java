package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {

	private Connection cn;
	private PreparedStatement pstRegister;
	private PreparedStatement pstDisplay;
	private PreparedStatement pstIncrCount;
	private PreparedStatement pstTop2Cand;
	private PreparedStatement pstPartyAnalysis;
	private PreparedStatement pstRegister2;
	
	public CandidateDaoImpl() throws ClassNotFoundException, SQLException {

		cn = fetchConnection();

		pstRegister = cn.prepareStatement("insert into candidates values(default,?,?,0)");
		pstDisplay = cn.prepareStatement("select * from candidates");
		pstIncrCount = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pstTop2Cand = cn.prepareStatement("select name,party,votes from candidates ORDER BY votes desc limit 2");
		pstPartyAnalysis = cn.prepareStatement("select party,sum(votes) from candidates GROUP BY party");
		pstRegister2 = cn.prepareStatement("insert into candidates values(default,?,?,0)");
		
		System.out.println("CandidateDaoImpl constructor...");
	}

	@Override
	public String registerCandidate(String name, String party) throws SQLException {
		String msg = "Regisration failed...";
		// set IN parameters
		pstRegister.setString(1, name);
		pstRegister.setString(2, party);

		int registerCount = pstRegister.executeUpdate();
		if (registerCount == 1)
			msg = "Registration succeeded...";
		return msg;
	}

	@Override
	public List<Candidate> displayCandidate() throws SQLException {

		ArrayList<Candidate> candidateList = new ArrayList<>();

		try (ResultSet rst = pstDisplay.executeQuery()) {

			while (rst.next()) {
				candidateList.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidateList;
	}

	@Override
	public void incrementCount(int candidateId) throws SQLException {
		// set IN parameters
		pstIncrCount.setInt(1, candidateId);

		int incrementCount = pstIncrCount.executeUpdate();
		if (incrementCount == 1)
			System.out.println("Vote added...");
		else
			System.out.println("Vote doesnt added...");

	}

	@Override
	public List<Candidate> topTwoAnalysis() throws SQLException {
		List<Candidate> list = new ArrayList<>();

		try (ResultSet rst = pstTop2Cand.executeQuery()) {
			while (rst.next()) {
				list.add(new Candidate(rst.getString(1), rst.getString(2), rst.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	@Override
	public LinkedHashMap<String, Integer> partyWiseAnalysis() throws SQLException {
		LinkedHashMap<String, Integer> candidateMap = new LinkedHashMap<>();
		
		try (ResultSet rst = pstPartyAnalysis.executeQuery()) {
			while (rst.next()) {
				candidateMap.put(rst.getString(1), rst.getInt(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return candidateMap;
	}
		
	
	@Override
	public String registerCandidate2(Candidate c) throws SQLException {
		
		
		String msg = "Regisration failed...";
		// set IN parameters
		pstRegister.setString(1, c.getName());
		pstRegister.setString(2, c.getParty());

		int registerCount = pstRegister.executeUpdate();
		if (registerCount == 1)
			msg = "Registration succeeded...";
		return msg;
	}

	
	public void cleanUp() throws SQLException {
		if (pstRegister != null)
			pstRegister.close();

		if (pstDisplay != null)
			pstDisplay.close();

		if (pstIncrCount != null)
			pstIncrCount.close();

		if (pstTop2Cand != null)
			pstTop2Cand.close();
		
		if(pstPartyAnalysis != null)
			pstPartyAnalysis.close();
		
		if(pstRegister2 != null )
			pstRegister2.close();
		
		System.out.println("Voter DAO cleaned up...");

	}
	
}

