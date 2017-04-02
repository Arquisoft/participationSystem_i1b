package es.uniovi.asw.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Category;
import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.model.Proposal;

@Component("proposalController")
@Scope("request")
public class ProposalController {
	
	private String title;
	private String description;
	private Proposal proposal;
	@Autowired
	private Factories factoria;
	
	private Citizen citizen;
	private Category selectedCategory;
	
	
	public void addProposal(){
		proposal= new Proposal(title,description,citizen,0,new Date(),selectedCategory);
		factoria.getServicesFactory().getProposalService().save(proposal);
	}

}
