package es.uniovi.asw;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

import es.uniovi.asw.business.CategoryService;
import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.business.CommentService;
import es.uniovi.asw.business.ProposalService;
import es.uniovi.asw.business.ServicesFactory;
import es.uniovi.asw.business.VoteService;
import es.uniovi.asw.business.impl.ServicesFactoryImpl;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Category;
import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.model.Comment;
import es.uniovi.asw.persistence.model.Proposal;
import es.uniovi.asw.persistence.model.Vote;
import es.uniovi.asw.persistence.model.VoteComment;
import es.uniovi.asw.persistence.model.VoteProposal;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelTest {
	
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
	public void testCitizen() {
		
		CitizenService service = servicesFactory.getCitizenService();
		Citizen gabriel = new Citizen("Gabriel","Reguero",createDate("31/12/1995"), "emailGabriel@test.com","55433455B", "dd","dd", 2);
		Citizen nacho = new Citizen("Nacho", "Fernandez", createDate("08/01/1995"), "emailNacho@test.com", "71729768J", "mi casa", "española", 47);
		
		service.save(gabriel);
		service.save(nacho);

		assertNotNull(service.findByEmail(gabriel.getEmail()));
		assertNotNull(service.findByEmail(nacho.getEmail()));

		

	}
	@Test
	public void testVote() {
		
		CitizenService service1 = servicesFactory.getCitizenService();
		
		Citizen oscar = new Citizen("Gabriasdael","Reguasdero",createDate("31/12/1995"), "emadsilGabriel@test.com","55433955B", "dd","dd", 2);
		Citizen pedro = new Citizen("Naasdcho", "Fernasdandez", createDate("08/01/1995"), "emasdilNacho@test.com", "71769768J", "mi casa", "española", 47);
		
		service1.save(oscar);
		service1.save(pedro);
		
		CategoryService catService = servicesFactory.getCategoryService();
		Category sports = new Category("Sport");
		Category travels = new Category("Travels");
		catService.save(sports);
		catService.save(travels);
		
		ProposalService service3= servicesFactory.getProposalService();

		Proposal proposal1= new Proposal("Hacer que Ana deje becaria", "Ana no em cae bien y quiero que se pire", oscar, 0, createDate("31/12/1985"), sports);
		Proposal proposal2= new Proposal("Hacer que Luiso vaya a Ingles", "Luiso nunca va a Ingles porque quiere verme", pedro, 0, createDate("31/12/1995"), travels);
		
		service3.save(proposal1);
		service3.save(proposal2);
		
		CommentService service2= servicesFactory.getCommentService();
		
		Comment coment1= new Comment("¡Qué feo eres!",proposal1,oscar,createDate("08/01/1995"),0);
		Comment coment2= new Comment("¡Qué guapo eres!",proposal2,pedro,createDate("08/05/1995"),0);
		
		service2.save(coment1);
		service2.save(coment2);
		
		VoteService service = servicesFactory.getVoteService();
		
		Vote vote1= new VoteComment(oscar,coment1);
		Vote vote2= new VoteProposal(pedro,proposal2);
		
				
		service.save(vote1);
		service.save(vote2);

		assertNotNull(service.findCommentVotesByCitizen(oscar));
		assertNull(service.findProposalVotesByCitizen(oscar));
		
		assertNull(service.findCommentVotesByCitizen(pedro));
		assertNotNull(service.findProposalVotesByCitizen(oscar));
		

		

	}

	

}
