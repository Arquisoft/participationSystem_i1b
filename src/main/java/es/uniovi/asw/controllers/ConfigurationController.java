package es.uniovi.asw.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Category;
import es.uniovi.asw.persistence.model.Configuration;
import es.uniovi.asw.persistence.model.ForbiddenWords;

@Component("configController")
@Scope("session")
public class ConfigurationController {

	private int timelife;
	private Configuration conf;
	List<Category> oldCategories;
	List<Category> actualCategories;
	List<ForbiddenWords> words;
	
	//event attributes
	 private boolean skip;
	 private String addWordInput;
	 private String blabla;

	@Autowired
	private Factories factoria;

	@PostConstruct
	public void init() {
		conf = factoria.getServicesFactory().getConfigurationService().actualConfiguration();
		oldCategories = factoria.getServicesFactory().getCategoryService().findAll();
		actualCategories = new ArrayList<>(oldCategories);
		words = new ArrayList<ForbiddenWords>(conf.getForbiddenWords());
	}
	
	void addForbiddenWord() {
		System.out.println("Tamaño antes añadir: "+words.size());
		ForbiddenWords fb = new ForbiddenWords(addWordInput, conf);
		conf.addWord(fb);
		words.add(fb);
		System.out.println("Tamaño despues añadir: "+words.size());
	}
	
	void removeForbiddenWord(String word) {
		ForbiddenWords fb = new ForbiddenWords(word, conf);
		conf.removeWord(fb);
		words.remove(fb);

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
	
	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
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

	public int getTimelife() {
		return timelife;
	}

	public void setTimelife(int timelife) {
		this.timelife = timelife;
	}

	public Configuration getConf() {
		return conf;
	}

	public void setConf(Configuration conf) {
		this.conf = conf;
	}

	public List<Category> getOldCategories() {
		return oldCategories;
	}

	public void setOldCategories(List<Category> oldCategories) {
		this.oldCategories = oldCategories;
	}

	public List<Category> getActualCategories() {
		return actualCategories;
	}

	public void setActualCategories(List<Category> actualCategories) {
		this.actualCategories = actualCategories;
	}

	public List<ForbiddenWords> getWords() {
		return words;
	}

	public void setWords(List<ForbiddenWords> words) {
		this.words = words;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String getAddWordInput() {
		return addWordInput;
	}

	public void setAddWordInput(String addWordInput) {
		this.addWordInput = addWordInput;
	}
	

}
