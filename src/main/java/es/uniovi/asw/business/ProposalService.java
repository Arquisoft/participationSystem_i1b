package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.persistence.model.Proposal;

public interface ProposalService {
	void save(Proposal proposal);
	void delete(Proposal proposal);
	List<Proposal> findAll();
	boolean alreadyExists(Proposal proposal);
}
