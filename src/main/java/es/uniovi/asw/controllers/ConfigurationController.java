package es.uniovi.asw.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Category;
import es.uniovi.asw.persistence.model.Configuration;
import es.uniovi.asw.persistence.model.ForbiddenWords;

@Component("configController")
@Scope("request")
public class ConfigurationController {

	private int timelife;
	private Configuration conf;
	List<Category> oldCategories;
	List<Category> actualCategories;

	@Autowired
	private Factories factoria;

	@PostConstruct
	public void init() {
		conf = factoria.getServicesFactory().getConfigurationService().actualConfiguration();
		oldCategories = factoria.getServicesFactory().getCategoryService().findAll();
		actualCategories = new ArrayList<>(oldCategories);
	}
	
	void addForbiddenWord(String word) {
		ForbiddenWords fb = new ForbiddenWords(word, conf);
		conf.addWord(fb);
	}
	
	void removeForbiddenWord(String word) {
		ForbiddenWords fb = new ForbiddenWords(word, conf);
		conf.removeWord(fb);
	}

	void addProvisionalCategory(String cat){
		Category c = new Category(cat);
		actualCategories.add(c);
	}

	void removeProvisionalCategory(String cat){
		Category c = new Category(cat);
		if(actualCategories.contains(c)){
			actualCategories.remove(c);
		}
	}

	void saveConfig() {
		for(Category c : actualCategories){
			if(!oldCategories.contains(c)) {
				factoria.getServicesFactory().getCategoryService().save(c);
			}
		}

		factoria.getServicesFactory().getConfigurationService().save(conf);
	}

}
