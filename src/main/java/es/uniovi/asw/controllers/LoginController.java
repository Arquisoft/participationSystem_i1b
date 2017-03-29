package es.uniovi.asw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Citizen;

@Controller
@Component("loginController")
@Scope("request")
public class LoginController {

	private String user;
	private String pass;
	@Autowired
	private Factories factoria;
	
	public String logIn(){
		
//		Citizen cit=factoria.getServicesFactory().getCitizenService().findByEmail(user);
//		
//		if(cit!=null && pass.equals(cit.getPassword()))
		if(user.equals("root"))
		{
			return "success";
		}
		return "error";
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
