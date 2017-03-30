package es.uniovi.asw.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private int score;
	@OneToMany(mappedBy="comment")
	private List<Vote> votes= new ArrayList<Vote>();
	
	public Comment(){}

	public Comment(String text, Proposal proposal, Citizen citizen, Date creationDate, int score) {
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
		Association.Commenting.link(this.citizen, this);
	}

	void _setCitizen(Citizen citizen) {
	
		this.citizen=citizen;

		
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public List<Vote> getVotes() {
		return new ArrayList<Vote>();
	}

	public List<Vote> _getVotes() {
		return votes;
	}
	
}
