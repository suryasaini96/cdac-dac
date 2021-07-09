package tester;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.CandidateDaoImpl;
import dao.ICandidateDao;
import dao.IVoterDao;
import dao.VoterDaoImpl;
import pojos.Candidate;
import pojos.Voter;

public class Main {

	public static void main(String[] args) throws SQLException {
		System.out.println("Welcome to the Election Voting System!");
		try(Scanner sc = new Scanner(System.in)){
			boolean exit = false;
			while(!exit) {
				System.out.println("1. Voter Login");
				System.out.println("2. Candidate Registration");
				System.out.println("3. List all candidates");
				System.out.println("4. Cast a vote");
				System.out.println("5. Exit");
				System.out.print("Enter choice: ");
				switch(sc.nextInt()) {
				case 1: System.out.println("Enter email and password: ");
						IVoterDao voterDao = new VoterDaoImpl();
						Voter voter = voterDao.authenticateVoter(sc.next(), sc.next());
						if (voter!=null) {
							System.out.println("Voter login successful.");
							System.out.println("Your details are: ");
							System.out.println(voter);
						} else {
							System.out.println("User has already voted!");
						}
						break;
				case 2: System.out.println("Enter name and party: ");
						ICandidateDao candidateDao1 = new CandidateDaoImpl();
						String msg = candidateDao1.registerCandidate(sc.next(), sc.next());
						System.out.println(msg);
						break;
				case 3: ICandidateDao candidateDao2 = new CandidateDaoImpl();
						List<Candidate> candidates = candidateDao2.listCandidates();
						candidates.stream().forEach(System.out::println);
						break;
				case 4: System.out.println("Enter candidate id & voter id");
						ICandidateDao candidateDao3 = new CandidateDaoImpl();
						IVoterDao voterDao1 = new VoterDaoImpl();
						if (candidateDao3.updateVotes(sc.nextInt()) && voterDao1.updateStatus(sc.nextInt()))
							System.out.println("Vote casted successfully");
						else
							System.out.println("Vote failed!");
						break;
				case 5:
				default:System.out.println("Exited."); 
						exit = true;
						break;
				}
			}
		}
		

	}

}
