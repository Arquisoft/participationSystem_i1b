package es.uniovi.asw.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.business.ServicesFactory;

public class Factories {
	
	@Autowired
	private static ServicesFactory servicesFactory;
	
	public static ServicesFactory getServicesFactory() {
		return servicesFactory;
	}

}
