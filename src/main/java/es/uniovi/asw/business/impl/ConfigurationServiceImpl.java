package es.uniovi.asw.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.ConfigurationService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Configuration;

@Service
public class ConfigurationServiceImpl implements ConfigurationService{

	@Autowired
	private Factories factories;
	
	@Override
	public void save(Configuration conf) {
		factories.getPersistenceFactory().getConfigurationRepository().save(conf);
	}

	@Override
	public Configuration actualConfiguration() {
		List<Configuration> confs = factories.getPersistenceFactory().getConfigurationRepository().findAll();
		return confs.get(confs.size());
	}

}
