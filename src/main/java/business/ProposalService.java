package business;

import persistence.models.Proposal;

public interface ProposalService {
	void save(Proposal proposal);
	void delete(Proposal proposal);
}
