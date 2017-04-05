package es.uniovi.asw.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Citizen;
import es.uniovi.asw.persistence.model.Comment;
import es.uniovi.asw.persistence.model.Proposal;
import es.uniovi.asw.persistence.model.Vote;
import es.uniovi.asw.persistence.model.VoteProposal;

@Component("ProposalListController")
@Scope("session")
public class ProposaListController {

	private String title;
	private String description;
	@Autowired
	private Factories factoria;

	private Citizen citizen;
	private List<Proposal> list;
	private Proposal selectedProposal;
	private List<Comment> comments;
	private int score;
	private VoteProposal vote;

	


	@PostConstruct
	public void init() {
		list= factoria.getServicesFactory().getProposalService().findAll();
	}

	

	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}



	public Citizen getCitizen() {
		return citizen;
	}


	public List<Proposal> getList() {
		return list;
	}

	
	

	public Proposal getSelectedProposal() {
		return selectedProposal;
	}



	public void setSelectedProposal(Proposal selectedProposal) {
		this.selectedProposal = selectedProposal;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}



	public void setList(List<Proposal> list) {
		this.list = list;
	}

	
	public List<Proposal> showProposals()
	{
		 list = factoria.getServicesFactory().getProposalService().findAll();
		return list;
	}
	
	public String selectProposal(Proposal pr)
	{
		selectedProposal=pr;
		title=selectedProposal.getTitle();
		description=selectedProposal.getDescription();
		score=selectedProposal.getScore();
		
		return "goToView";
	}
	
	public String goToAddView(){
		return "addView";
	}
	public List<Comment> showComments()
	{
		 comments = factoria.getServicesFactory().getProposalService().findByProposal(selectedProposal);
		return comments;
	}
	
	public String voteProposal(Proposal pr){
		selectedProposal=pr;
		System.out.println("votando");
		vote= new VoteProposal(citizen,selectedProposal);
		if(factoria.getServicesFactory().getVoteService().findProposalVotesByCitizen(citizen).contains(vote)){
			return "not_working";
			
		}
		else{
			factoria.getServicesFactory().getVoteService().save(vote);
			selectedProposal.setScore(score++);
			factoria.getServicesFactory().getProposalService().save(selectedProposal);
			return "working";
			
		}
	}

	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public VoteProposal getVote() {
		return vote;
	}



	public void setVote(VoteProposal vote) {
		this.vote = vote;
	}




	
}
