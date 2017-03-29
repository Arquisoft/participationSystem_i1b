package business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import business.ProposalService;
import persistence.models.Proposal;
import persistence.repositories.ProposalRepository;

public class ProposalServiceImpl implements ProposalService{
	
	@Autowired
	private ProposalRepository repository;

	@Override
	public void save(Proposal proposal) {
		// TODO Auto-generated method stub
		repository.save(proposal);
	}

	@Override
	public void delete(Proposal proposal) {
		// TODO Auto-generated method stub
		repository.delete(proposal);
	}

	public ProposalRepository getRepository() {
		return repository;
	}

}
