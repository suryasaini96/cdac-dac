package dao;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {

	String registerCandidate(String name, String party) throws SQLException;
	
	List<Candidate> displayCandidate() throws SQLException;
	
	void incrementCount(int candidateId) throws SQLException;
	
	List<Candidate> topTwoAnalysis() throws SQLException;
	
	LinkedHashMap<String, Integer> partyWiseAnalysis() throws SQLException;
	
	String registerCandidate2(Candidate c) throws SQLException;
}
