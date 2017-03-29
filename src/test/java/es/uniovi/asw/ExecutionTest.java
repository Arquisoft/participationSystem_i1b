package es.uniovi.asw;

import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.business.ServicesFactory;
import es.uniovi.asw.business.impl.ServicesFactoryImpl;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Citizen;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecutionTest {
	
	@Autowired
	private ServicesFactory servicesFactory;

	
	private Date createDate(String dateStr)
	{
		Date date = null;
		DateFormat format= new SimpleDateFormat("dd/MM/yyyy");
		try {
			date= format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	@Test
	public void testCheckUsers() {
		
		CitizenService service = servicesFactory.getCitizenService();
		Citizen gabriel = new Citizen("Gabriel","Reguero",createDate("31/12/1995"), "emailGabriel@test.com","55433455B", "dd","dd", 2);
		Citizen nacho = new Citizen("Nacho", "Fernandez", createDate("08/01/1995"), "emailNacho@test.com", "71729768J", "mi casa", "española", 47);
		
		service.save(gabriel);
		service.save(nacho);

		assertNotNull(service.findByEmail(gabriel.getEmail()));
		assertNotNull(service.findByEmail(nacho.getEmail()));

		

	}
	

}
