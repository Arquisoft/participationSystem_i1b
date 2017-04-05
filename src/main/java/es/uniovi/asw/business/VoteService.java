package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.model.Vote;
import es.uniovi.asw.persistence.model.VoteComment;
import es.uniovi.asw.persistence.model.VoteProposal;

public interface VoteService {
	void save(Vote vote);
	List<Vote> findCommentVotesByCitizen(Citizen citizen);
	List<Vote> findProposalVotesByCitizen(Citizen citizen);
}
