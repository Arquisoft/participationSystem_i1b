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


	

}
