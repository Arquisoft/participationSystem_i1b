package es.uniovi.asw.business;

import es.uniovi.asw.persistence.model.Configuration;
import es.uniovi.asw.persistence.model.ForbiddenWords;

public interface ForbiddenWordsService {
	
	void save(ForbiddenWords word);
	void remove(ForbiddenWords word);

}