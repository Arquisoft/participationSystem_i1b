package es.uniovi.asw.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Proposal")
public class Proposal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String title;
	private String description;
	@ManyToOne
	private Citizen citizen; //the citizen that creates it
	private int score;
	private Date creationDate;
	@OneToMany(mappedBy="proposal")
	private List<Comment> comments= new ArrayList<Comment>();
	@OneToMany(mappedBy="proposal", fetch=FetchType.EAGER)
	private List<VoteProposal> votes= new ArrayList<VoteProposal>();
	@ManyToOne
	private Category category;

	protected Proposal() {}

	public Proposal(String title, String description, Citizen citizen, int score, Date creationDate, Category cat) {
		super();
		this.title = title;
		this.description = description;
		this.citizen = citizen;
		this.score = score;
		this.creationDate = creationDate;
		setCategory(cat);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Comment> getComments() {

		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public List<VoteProposal> getVotes() {
		return new ArrayList<VoteProposal>(votes);
	}

	List<VoteProposal> _getVotes() {
		return votes;
	}

	void _setCitizen(Citizen citizen2) {
		this.citizen=citizen2;

	}
	public void setCitizen(Citizen citizen) {
		Association.Propose.link(citizen, this);
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		Association.CategorizeProposal.link(category, this);
	}
	
	void _setCategory(Category category){
		this.category = category;
	}

}
