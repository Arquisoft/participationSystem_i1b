package es.uniovi.asw.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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

	private int lifetime;
	private Configuration conf;
	List<Category> oldCategories;
	List<Category> actualCategories;
	List<ForbiddenWords> words;
	private ForbiddenWords selectedWord;
	
	//event attributes
	 private boolean skip;
	 private String addWordInput;

	@Autowired
	private Factories factoria;

	@PostConstruct
	public void init() {
		conf = factoria.getServicesFactory().getConfigurationService().actualConfiguration();
		oldCategories = factoria.getServicesFactory().getCategoryService().findAll();
		actualCategories = new ArrayList<>(oldCategories);
		if(conf != null)
		{
			words = new ArrayList<ForbiddenWords>(conf.getForbiddenWords());
			lifetime = conf.getDeadline();
		}
		else{
			words = new ArrayList<ForbiddenWords>();
			lifetime = 0;
		}		
	}
	
	public void addForbiddenWord() {
		ForbiddenWords fb = new ForbiddenWords(addWordInput, conf);
		if(!words.contains(fb)){
			//System.out.println("Doesnt contain:"+fb.getWord());
			conf.addWord(fb);
			words.add(fb);
			//System.out.println("adding word");
		}
		else{
			warningForbiddenWord();
		}
		addWordInput = "";
	}
	
	public void removeForbiddenWord() {
		if(selectedWord!=null)
		{
			conf.removeWord(selectedWord);
			words.remove(selectedWord);
		}

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

	public void warningForbiddenWord() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "This word is already forbidden!"));
    }
	
	void saveConfig() {
		for(Category c : actualCategories){
			if(!oldCategories.contains(c)) {
				factoria.getServicesFactory().getCategoryService().save(c);
			}
		}

		factoria.getServicesFactory().getConfigurationService().save(conf);
	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
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

	public ForbiddenWords getSelectedWord() {
		return selectedWord;
	}

	public void setSelectedWord(ForbiddenWords selectedWord) {
		this.selectedWord = selectedWord;
	}
	

}
