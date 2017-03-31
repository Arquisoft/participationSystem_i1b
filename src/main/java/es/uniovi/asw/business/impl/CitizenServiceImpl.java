package es.uniovi.asw.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.repositories.CitizenRepository;

@Service
public class CitizenServiceImpl implements CitizenService{
	
	@Autowired
	private Factories factories;

	@Override
	public void save(Citizen citizen) {
		factories.getPersistenceFactory().getCitizenRepository().save(citizen);
	}

	@Override
	public void delete(Citizen citizen) {
		factories.getPersistenceFactory().getCitizenRepository().delete(citizen);
	}

	@Override
	public List<Citizen> findAll() {
		return factories.getPersistenceFactory().getCitizenRepository().findAll();
	}

	@Override
	public Citizen findByEmail(String email) {
		
		return factories.getPersistenceFactory().getCitizenRepository().findByEmail(email);
	}

}
