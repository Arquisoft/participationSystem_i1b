package persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import persistence.models.Citizen;


public interface CitizenRepository extends CrudRepository<Citizen, Long> {

	Citizen findByEmail(String email);
	
	Citizen findByNif(String Nif);
	
}
