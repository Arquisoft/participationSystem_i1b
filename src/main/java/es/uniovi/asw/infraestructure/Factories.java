package es.uniovi.asw.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.uniovi.asw.business.ServicesFactory;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("es.uniovi.asw.persistence.repositories")
public class Factories {
	
	@Autowired
	private static ServicesFactory servicesFactory;
	
	public ServicesFactory getServicesFactory() {
		return servicesFactory;
	}

}
