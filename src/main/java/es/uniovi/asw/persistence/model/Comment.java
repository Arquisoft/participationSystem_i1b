package es.uniovi.asw.persistence.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="Comment")
public class Comment {
	@Id
	@GeneratedValue
	private Long id;
	private String text;
	@ManyToOne
	private Proposal proposal;
	@ManyToOne
	private Citizen citizen;
	private Date creationDate;
	private Long score;
	
	public Comment(){}

	public Comment(String text, Proposal proposal, Citizen citizen, Date creationDate, Long score) {
		super();
		this.text = text;
		this.proposal = proposal;
		this.citizen = citizen;
		this.creationDate = creationDate;
		this.score = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getId() {
		return id;
	}


}
