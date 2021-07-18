package dao;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {
	//add a method to ret list of all candidates 
	List<Candidate> getAllCandidates() throws SQLException;
	//add a method to inc vote count
	String incrementVotes(int candidateId)throws SQLException;
	//add a method to register new candidate
	String registerCandidate(Candidate candidate) throws SQLException;
	//add a method to display top 2 candidates having max votes
	List<Candidate> getTop2Candidates() throws SQLException;
	//add a method to get partywise votes analysis
	LinkedHashMap<String , Integer> getVotesAnalysis() throws SQLException;
}
