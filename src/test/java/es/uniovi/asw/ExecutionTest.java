package es.uniovi.asw;

import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import business.CitizenService;
import business.impl.CitizenServiceImpl;
import persistence.models.Citizen;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
@IntegrationTest
public class ExecutionTest {
	

	CitizenService service = new CitizenServiceImpl();
	
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
		
		Citizen gabriel = new Citizen("Gabriel","Reguero",createDate("31/12/1995"), "emailGabriel@test.com","55433455B", "dd","dd", 2);
		Citizen nacho = new Citizen("Nacho", "Fernandez", createDate("08/01/1995"), "emailNacho@test.com", "71729768J", "mi casa", "española", 47);
		
		service.save(gabriel);
		service.save(nacho);

		assertNotNull(service.findByEmail(gabriel.getEmail()));
		assertNotNull(service.findByEmail(nacho.getEmail()));

		

	}
	

}
