package es.uniovi.asw.business;

import es.uniovi.asw.persistence.model.Configuration;

public interface ConfigurationService {

	void save(Configuration conf);
	
	Configuration actualConfiguration();
}
