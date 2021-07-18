package pojos;

public class Candidate {
//id | name    | party    | votes
	private int candidateId;
	private String name, party;
	private int votes;

	public Candidate() {
		// TODO Auto-generated constructor stub
	}

	public Candidate(int candidateId, String name, String party, int votes) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.party = party;
		this.votes = votes;
	}
	

	public Candidate(String name, String party) {
		super();
		this.name = name;
		this.party = party;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", name=" + name + ", party=" + party + ", votes=" + votes
				+ "]";
	}

}
