package es.uniovi.asw.business;

import es.uniovi.asw.persistence.model.Proposal;

public interface ProposalService {
	void save(Proposal proposal);
	void delete(Proposal proposal);
}
