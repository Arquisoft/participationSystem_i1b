package business;

import java.util.List;

import persistence.models.Citizen;

public interface CitizenService {
	void save(Citizen citizen);
	void delete(Citizen citizen);
	List<Citizen> findAll();
	Citizen findByEmail(String email);

}
