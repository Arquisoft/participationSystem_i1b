package persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import persistence.models.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

	Citizen findByEmail(String email);
	
}
