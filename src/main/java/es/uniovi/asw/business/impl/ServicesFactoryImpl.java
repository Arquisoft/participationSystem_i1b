package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.business.CommentService;
import es.uniovi.asw.business.ProposalService;
import es.uniovi.asw.business.ServicesFactory;
import es.uniovi.asw.business.VoteService;

@Service
public class ServicesFactoryImpl implements ServicesFactory {

	@Autowired
	private VoteService voteService;
	@Autowired
	private CitizenService citizenService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ProposalService proposalService;

	

	@Override
	public CitizenService getCitizenService() {
		return citizenService;
	}

	@Override
	public VoteService getVoteService() {
		return voteService;
	}

	@Override
	public CommentService getCommentService() {
		// TODO Auto-generated method stub
		return commentService;
	}

	@Override
	public ProposalService getProposalService() {
		// TODO Auto-generated method stub
		return proposalService;
	}
	
}
