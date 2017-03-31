package es.uniovi.asw.business;

import es.uniovi.asw.persistence.model.Administrator;
import es.uniovi.asw.persistence.model.Category;

public interface AdministratorService {
		
	boolean checkLogin(String user,String pass);
}
