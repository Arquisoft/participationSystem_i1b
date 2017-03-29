package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.business.ServicesFactory;

@Service
public class ServicesFactoryImpl implements ServicesFactory {

	@Autowired
	private CitizenService citizenService;

	@Override
	public CitizenService getCitizenService() {
		return citizenService;
	}
	
}
