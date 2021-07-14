package dao;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {
	String registerCandidate(String name, String party) throws SQLException;
	List<Candidate> listCandidates() throws SQLException;
	boolean updateVotes(int candidateId) throws SQLException;
	List<Candidate> top2Analysis() throws SQLException;
	LinkedHashMap<String,Integer> partywiseAnalysis() throws SQLException;
	void cleanUp() throws SQLException;
}
