package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.ProposalService;
import es.uniovi.asw.persistence.model.Proposal;
import es.uniovi.asw.persistence.repositories.ProposalRepository;

@Service
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
