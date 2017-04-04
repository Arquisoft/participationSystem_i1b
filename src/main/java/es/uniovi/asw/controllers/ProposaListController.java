package es.uniovi.asw.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Category;
import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.model.Proposal;

@Component("ProposalListController")
@Scope("session")
public class ProposaListController {

	private String title;
	private String description;
	@Autowired
	private Factories factoria;

	private Citizen citizen;
	private List<Proposal> list;
	private Proposal selectedProposal;
	


	@PostConstruct
	public void init() {
		list= factoria.getServicesFactory().getProposalService().findAll();
	}

	

	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}



	public Citizen getCitizen() {
		return citizen;
	}


	public List<Proposal> getList() {
		return list;
	}

	
	

	public Proposal getSelectedProposal() {
		return selectedProposal;
	}



	public void setSelectedProposal(Proposal selectedProposal) {
		this.selectedProposal = selectedProposal;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}



	public void setList(List<Proposal> list) {
		this.list = list;
	}

	
	public List<Proposal> showProposals()
	{
		 list = factoria.getServicesFactory().getProposalService().findAll();
		return list;
	}
	
	public void selectProposal(Proposal pr)
	{
		selectedProposal=pr;
		title=selectedProposal.getTitle();
		description=selectedProposal.getDescription();
	}
	
	public String goToAddView(){
		return "addView";
	}
	
	

}
