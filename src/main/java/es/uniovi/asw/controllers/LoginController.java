package es.uniovi.asw.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Administrator;
import es.uniovi.asw.persistence.model.Citizen;

@Component("loginController")
@Scope("request")
public class LoginController {

	private String user;
	private String pass;
	@Autowired
	private Factories factoria;
	
	public String logIn(){
		
		Administrator admin = new Administrator("admin", "admin");
		Citizen nacho = new Citizen("Nacho", "Fernandez", new Date(), "emailNacho@test.com", "71729768J", "mi casa", "española", 47);
		
		if(factoria.getServicesFactory().getAdministratorService().checkLogin(user, pass)) {
			return "conf";
		}
		else if(factoria.getServicesFactory().getCitizenService().checkLogin(user, pass)) {
			return "citizen";
		}
		else {
			return "error";
		}
//		Citizen cit=factoria.getServicesFactory().getCitizenService().findByEmail(user);
//		
//		if(cit!=null && pass.equals(cit.getPassword()))
//		{
//			return "success";
//		}
//		return "error";
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
