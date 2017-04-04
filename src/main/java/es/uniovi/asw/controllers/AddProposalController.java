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

@Component("addProposal")
@Scope("request")
public class AddProposalController {
	
	private String title;
	private String description;
	private Proposal proposal;
	private Citizen citizen;
	private String categoryName;
	private Category category;
	private List<Category> categories;
	private List<String> categoriesName=new ArrayList<String>();
	
	@Autowired
	private Factories factoria;
	
	@PostConstruct
	public void init() {
		categories= factoria.getServicesFactory().getCategoryService().findAll();
		citizen=(Citizen) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		for (Category category : categories) {
			categoriesName.add(category.getName());
		}
	}
	
	public String addProposal(){
		category= factoria.getPersistenceFactory().getCategoryRepository().findByName(categoryName);
		proposal= new Proposal(title,description,citizen,0,new Date(),category);
		factoria.getServicesFactory().getProposalService().save(proposal);
		
		return "success";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getCategoriesName() {
		return categoriesName;
	}

	public void setCategoriesName(List<String> categoriesName) {
		this.categoriesName = categoriesName;
	}
	

}
