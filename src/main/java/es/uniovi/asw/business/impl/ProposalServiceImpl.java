package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.ProposalService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Proposal;
import es.uniovi.asw.persistence.repositories.ProposalRepository;

@Service
public class ProposalServiceImpl implements ProposalService{
	
	@Autowired
	private Factories factories;
	
	@Override
	public void save(Proposal proposal) {
		// TODO Auto-generated method stub
		factories.getPersistenceFactory().getProposalRepository().save(proposal);
	}

	@Override
	public void delete(Proposal proposal) {
		// TODO Auto-generated method stub
		factories.getPersistenceFactory().getProposalRepository().delete(proposal);
	}


}
