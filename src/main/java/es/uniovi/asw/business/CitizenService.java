package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.persistence.model.Citizen;

public interface CitizenService {
	
	void save(Citizen citizen);
	void delete(Citizen citizen);
	List<Citizen> findAll();
	Citizen findByEmail(String email);
	boolean checkLogin(String email,String pass);
}
