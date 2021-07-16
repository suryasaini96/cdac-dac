package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

import static utils.DBUtils.*;

public class CandidateDaoImpl implements ICandidateDao {
	
	private Connection conn;
	private PreparedStatement psNewCandidate;
	private PreparedStatement psListCandidates;
	private PreparedStatement psGetVotes;
	private PreparedStatement psUpdateVotes;
	private PreparedStatement psTop2Candidates;
	private PreparedStatement psPartyAnalysis;
	
	public CandidateDaoImpl() throws SQLException {
		conn = fetchConnection();
		psNewCandidate = conn.prepareStatement("insert into candidates(name,party,votes) values(?,?,0)");
		psListCandidates = conn.prepareStatement("select * from candidates");
		psGetVotes = conn.prepareStatement("select votes from candidates where id=?");
		psUpdateVotes = conn.prepareStatement("update candidates set votes=? where id=?");
		psTop2Candidates = conn.prepareStatement("select * from candidates group by party order by sum(votes) desc limit 2");
		psPartyAnalysis = conn.prepareStatement("select party,sum(votes) from candidates group by party");
	}
	
	@Override
	public String registerCandidate(String name, String party) throws SQLException {
		psNewCandidate.setString(1, name);
		psNewCandidate.setString(2, party);
		int count = psNewCandidate.executeUpdate();
		if (count>0)
			return "Candidate registered.";
		return "Registration failed";
	}
	
	@Override
	public List<Candidate> listCandidates() throws SQLException {
		List<Candidate> list = new ArrayList<Candidate>();
		ResultSet rs = psListCandidates.executeQuery();
		while(rs.next()) {
			Candidate c = new Candidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			list.add(c);
		}
		if (list.size()==0)
			return null;
		return list;
	}

	@Override
	public boolean updateVotes(int id) throws SQLException {
		// Get current vote count
		psGetVotes.setInt(1, id);
		ResultSet rs = psGetVotes.executeQuery();
		rs.next();
		int votes = rs.getInt(1);
		
		// Increase the vote count
		psUpdateVotes.setInt(1, votes+1);
		psUpdateVotes.setInt(2, id);
		int count = psUpdateVotes.executeUpdate();
		if (count>0)
			return true;
		return false;
	}
	
	@Override
	public void cleanUp() throws SQLException {
		if(psNewCandidate!=null)
			psNewCandidate.close();
		if(psListCandidates!=null)
			psListCandidates.close();
		if(psGetVotes!=null)
			psGetVotes.close();
		if(psUpdateVotes!=null)
			psUpdateVotes.close();
		if(conn!=null)
			conn.close();
	}

	@Override
	public List<Candidate> top2Analysis() throws SQLException {
		ResultSet rs = psTop2Candidates.executeQuery();
		List<Candidate> top2Candidates = new ArrayList<Candidate>();
		while(rs.next()) {
			Candidate c = new Candidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			top2Candidates.add(c);
		}
		if(top2Candidates.size()==0)
			return null;
		return top2Candidates;
	}

	@Override
	public LinkedHashMap<String, Integer> partywiseAnalysis() throws SQLException{
		ResultSet rs = psPartyAnalysis.executeQuery();
		LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
		while(rs.next())
			map.put(rs.getString(1), rs.getInt(2));
		if (map.size()==0)
			return null;
		return map;
	}
}
