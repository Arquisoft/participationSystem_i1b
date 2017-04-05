package es.uniovi.asw.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.ProposalService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Proposal;

@Service
public class ProposalServiceImpl implements ProposalService{
	
	@Autowired
	private Factories factories;
	
	@Override
	public void save(Proposal proposal) {
		factories.getPersistenceFactory().getProposalRepository().save(proposal);
	}

	@Override
	public void delete(Proposal proposal) {
		factories.getPersistenceFactory().getProposalRepository().delete(proposal);
	}

	@Override
	public List<Proposal> findAll() {
		return factories.getPersistenceFactory().getProposalRepository().findAll();
	}
	
	@Override
	public boolean alreadyExists(Proposal proposal)
	{
		Proposal prop = factories.getPersistenceFactory().getProposalRepository().findByTitle(proposal.getTitle());
		if(prop != null)
		{
			return true;
		}
		return false;
	}


}
