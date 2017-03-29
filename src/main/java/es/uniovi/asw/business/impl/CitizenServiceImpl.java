package es.uniovi.asw.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.repositories.CitizenRepository;

@Service
public class CitizenServiceImpl implements CitizenService{
	
	@Autowired
	private CitizenRepository citizenRepository;

	@Override
	public void save(Citizen citizen) {
		// TODO Auto-generated method stub
		citizenRepository.save(citizen);
	}

	@Override
	public void delete(Citizen citizen) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Citizen> findAll() {
		// TODO Auto-generated method stub
		return citizenRepository.findAll();
	}

	@Override
	public Citizen findByEmail(String email) {
		// TODO Auto-generated method stub
		
		return citizenRepository.findByEmail(email);
	}

	public CitizenRepository getCitizenRepository() {
		return citizenRepository;
	}

}
