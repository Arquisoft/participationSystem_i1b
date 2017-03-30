package es.uniovi.asw.persistence.model;

public class Association {

	public static class Commenting {

		public static void link(Citizen citizen, Comment comment) {
			comment._setCitizen(citizen);
			citizen._getComments().add(comment);
		}
	}

	public static class Voting {

		public static void linkProposal(Citizen citizen, VoteProposal vote, Proposal proposal) {
			vote._setProposal(proposal);
			vote._setCitizen(citizen);

			proposal._getVotes().add(vote);
			citizen._getVotes().add(vote);
		}
		
		public static void linkComment(Citizen citizen, VoteComment vote, Comment comment) {
			vote._setComment(comment);
			vote._setCitizen(citizen);

			comment._getVotes().add(vote);
			citizen._getVotes().add(vote);
		}

//		public static void unlink(Citizen citizen, Vote vote, Proposal proposal) {
//			proposal._getVotes().remove(vote);
//			citizen._getVotes().remove(vote);
//
//			vote._setProposal(null);
//			vote._setCitizen(null);
//		}
	}

	public static class Propose {
		public static void link(Citizen citizen, Proposal proposal) {
			proposal._setCitizen(citizen);
			citizen._getProposals().add(proposal);
		}

		public static void unlink(Proposal proposal, Citizen citizen) {
			citizen._getProposals().remove(proposal);
			proposal._setCitizen(null);
		}
	}

}
