package es.uniovi.asw.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.VoteService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.model.Vote;
import es.uniovi.asw.persistence.repositories.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService{
	
	@Autowired
	private Factories factories;


	@Override
	public void save(Vote vote) {
		
		factories.getPersistenceFactory().getVoteRepository().save(vote);
	}

	@Override
	public List<Vote> findByCitizen(Citizen citizen) {
		return factories.getPersistenceFactory().getVoteRepository().findByCitizen(citizen);
	}



}
