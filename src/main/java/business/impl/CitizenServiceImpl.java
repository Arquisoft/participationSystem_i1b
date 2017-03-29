package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import business.CitizenService;
import persistence.models.Citizen;
import persistence.repositories.CitizenRepository;

@Component
public class CitizenServiceImpl implements CitizenService{
	
	@Autowired
	private CitizenRepository repository;

	@Override
	public void save(Citizen citizen) {
		// TODO Auto-generated method stub
		repository.save(citizen);
	}

	@Override
	public void delete(Citizen citizen) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Citizen> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Citizen findByEmail(String email) {
		// TODO Auto-generated method stub
		
		return repository.findByEmail(email);
	}

	public CitizenRepository getRepository() {
		return repository;
	}

}
