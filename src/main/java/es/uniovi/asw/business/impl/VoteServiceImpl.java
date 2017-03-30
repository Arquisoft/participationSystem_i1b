package es.uniovi.asw.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.VoteService;
import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.model.Vote;
import es.uniovi.asw.persistence.repositories.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService{
	
	@Autowired
	private VoteRepository voteRepository;


	@Override
	public void save(Vote vote) {
		// TODO Auto-generated method stub
		voteRepository.save(vote);
	}


	public VoteRepository getVoteRepository() {
		return voteRepository;
	}


	@Override
	public List<Vote> findByCitizen(Citizen citizen) {
		// TODO Auto-generated method stub
		return voteRepository.findByCitizen(citizen);
	}



}
