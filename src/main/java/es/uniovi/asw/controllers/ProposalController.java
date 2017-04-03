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

@Component("newProposalController")
@Scope("request")
public class ProposalController {

	private String title;
	private String description;
	private Proposal proposal;
	private Proposal selectedproposal;
	@Autowired
	private Factories factoria;

	private Citizen citizen;
	private Category selectedCategory;
	private List<Category> categories;
	private List<String> categoriesName=new ArrayList<String>();

	@PostConstruct
	public void init() {
		categories= factoria.getServicesFactory().getCategoryService().findAll();
		for (Category category : categories) {
			categoriesName.add(category.getName());
		}
	}


	public String addProposal(){
		citizen=(Citizen) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		proposal= new Proposal(title,description,citizen,0,new Date(),selectedCategory);
		factoria.getServicesFactory().getProposalService().save(proposal);
		
		return "success";
	}

	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public Category getSelectedCategory() {
		return selectedCategory;
	}

	public List<Category> getCategories() {
		return categories;
	}


	public List<String> getCategoriesName() {
		return categoriesName;
	}
	
	public List<Proposal> showProposals()
	{
		List<Proposal> list = factoria.getServicesFactory().getProposalService().findAll();
		return list;
	}
	
	public void selectProposal(Proposal pr)
	{
		selectedproposal=pr;
	}
	
	

}
