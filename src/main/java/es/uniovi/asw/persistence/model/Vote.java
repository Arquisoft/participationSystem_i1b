package es.uniovi.asw.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Vote")
public class Vote {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Citizen citizen;
	@ManyToOne
	private Comment comment;
	@ManyToOne
	private Proposal proposal;
	
	
	public Vote(){}

	public Vote(Citizen citizen, Comment comment) {
		this.citizen = citizen;
		this.comment = comment;
	}
	public Vote(Citizen citizen, Proposal proposal) {
		this.citizen = citizen;
		this.proposal = proposal;
	}
	
	public Long getId() {
		return id;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public Comment getComment() {
		return comment;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal2) {
		Association.VotingProposal.link(citizen, this, proposal2);
	}
	void _setProposal(Proposal proposal2) {
		this.proposal=proposal2;
	}

	void _setCitizen(Citizen citizen2) {
		this.citizen=citizen2;
		
	}

	public void setCitizen(Citizen citizen2) {
		Association.VotingProposal.link(citizen2, this, proposal);
		
	}

	

}
