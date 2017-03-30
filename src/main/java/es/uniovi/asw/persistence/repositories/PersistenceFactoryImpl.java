package es.uniovi.asw.persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistenceFactoryImpl implements PersistenceFactory{
	
	@Autowired
	private VoteRepository voteRepository;
	@Autowired
	private CitizenRepository citizenRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private ProposalRepository proposalRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public CitizenRepository getCitizenRepository() {
		return citizenRepository;
	}
	@Override
	public VoteRepository getVoteRepository() {
		return voteRepository;
	}
	@Override
	public CommentRepository getCommentRepository() {
		return commentRepository;
	}
	@Override
	public ProposalRepository getProposalRepository() {
		return proposalRepository;
	}
	@Override
	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}


}
