package persistence.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Proposal")
public class Proposal {

	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true,nullable = false)
	private String title;
	@Column(unique = true,nullable = false)
	private String description;
	@Column(nullable = false)
	private Long creatorId;
	@Column(unique = true, nullable = false)
	private int score;
	@Column(unique = true, nullable = false)
	private int numComments;
	
	protected Proposal() {}

	public Proposal(String title, String description, Long creatorId, int score, int numComments) {
		this.title = title;
		this.description = description;
		this.creatorId = creatorId;
		this.score = score;
		this.numComments = numComments;
	}
	
}
