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
@Scope("session")
public class NewProposalController {

	private String title;
	private String description;
	private Proposal proposal;
//	private Proposal selectedproposal;
	@Autowired
	private Factories factoria;

	private Citizen citizen;
	private Category selectedCategory;
	private List<Category> categories;
	private List<String> categoriesName=new ArrayList<String>();
	


	@PostConstruct
	public void init() {
		categories= factoria.getServicesFactory().getCategoryService().findAll();
	}

	public String addProposal(){
		selectedCategory= factoria.getPersistenceFactory().getCategoryRepository().findByName("coches");
		System.out.println("Category array count:"+categories.size());
		System.out.println("Category:"+selectedCategory);
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

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setCategoriesName(List<String> categoriesName) {
		this.categoriesName = categoriesName;
	}
	
//	public List<Proposal> showProposals()
//	{
//		List<Proposal> list = factoria.getServicesFactory().getProposalService().findAll();
//		return list;
//	}
//	
//	public void selectProposal(Proposal pr)
//	{
//		selectedproposal=pr;
//	}
	
	

}
