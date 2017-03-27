package persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.models.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long>{
	
	Proposal findByTitle(String title);

}
