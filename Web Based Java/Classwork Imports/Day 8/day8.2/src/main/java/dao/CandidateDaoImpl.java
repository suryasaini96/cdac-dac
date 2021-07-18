package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static utils.DBUtils.*;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5;

	public CandidateDaoImpl() throws Exception {
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from candidates");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3 = cn.prepareStatement("insert into candidates values (default,?,?,?)");
		pst4 = cn.prepareStatement("select * from candidates order by votes desc limit 2");
		pst5 = cn.prepareStatement("select party,sum(votes) from candidates group by party");
		System.out.println("candidate dao created...");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidates = new ArrayList<>();
		System.out.println("in candidate dao exec : list candidates query");
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (pst5 != null)
			pst5.close();
		System.out.println("candidate dao cleaned up...");
	}

	@Override
	public String incrementVotes(int candidateId) throws SQLException {
		// set IN param candidate id
		pst2.setInt(1, candidateId);
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Votes incremented";
		return "Votes incr failed...";
	}

	@Override
	public String registerCandidate(Candidate candidate) throws SQLException {
		// Set IN params
		pst3.setString(1, candidate.getName());
		pst3.setString(2, candidate.getParty());
		pst3.setInt(3, candidate.getVotes());
		int count = pst3.executeUpdate();
		if (count == 1)
			return "Candidate reg successful";
		return "Candidate reg  failed";
	}

	@Override
	public List<Candidate> getTop2Candidates() throws SQLException {
		List<Candidate> candidates = new ArrayList<>();
		try (ResultSet rst = pst4.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}

	@Override
	public LinkedHashMap<String, Integer> getVotesAnalysis() throws SQLException {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		try (ResultSet rst = pst5.executeQuery()) {
			while (rst.next())
				map.put(rst.getString(1), rst.getInt(2));
		}
		return map;
	}

}
