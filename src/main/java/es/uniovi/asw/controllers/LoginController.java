package es.uniovi.asw.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("loginController")
@Scope("request")
public class LoginController {

	private String user;
	private String pass;
	
	public String logIn(){
		if(user.equals("correct"))
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
