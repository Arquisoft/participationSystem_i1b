package es.uniovi.asw.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long>{
	
	List<Vote> findByCitizen(Citizen citizen);

}
