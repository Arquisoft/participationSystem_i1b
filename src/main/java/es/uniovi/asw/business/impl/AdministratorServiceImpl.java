package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.AdministratorService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Administrator;
import es.uniovi.asw.persistence.model.Citizen;

@Service
public class AdministratorServiceImpl implements AdministratorService{

	@Autowired
	private Factories factories;

	@Override
	public boolean checkLogin(String user, String pass) {
		Administrator a = null;
		a = factories.getPersistenceFactory().getAdministratorRepository().findByUsername(user);
		if(a != null && a.getPassword().equals(pass)) {
			return true;
		}
		return false;
	}
}
