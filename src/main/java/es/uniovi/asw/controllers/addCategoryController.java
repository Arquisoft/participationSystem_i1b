package es.uniovi.asw.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Category;

@Component("addCategoryController")
@Scope("request")
public class addCategoryController {
	
	private String name;
	private Category category;
	private List<Category> categoriesList;

	
	@Autowired
	private Factories factoria;
	
	@PostConstruct
	public void init() {
		categoriesList= factoria.getServicesFactory().getCategoryService().findAll();
	}
	
	public String addCategory(){
		
		category=new Category(name);
		factoria.getServicesFactory().getCategoryService().save(category);
		
		return "working";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategoriesList() {
		return categoriesList;
	}

	public void setCategoriesList(List<Category> categoriesList) {
		this.categoriesList = categoriesList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
