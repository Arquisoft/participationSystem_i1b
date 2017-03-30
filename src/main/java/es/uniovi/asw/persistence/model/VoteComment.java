package es.uniovi.asw.persistence.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("P")
@Table(name="VoteProposal")
public class VoteComment extends Vote{

	@ManyToOne
	private Comment comment;

	public VoteComment(Citizen citizen, Comment comment) {
		super(citizen);
		this.comment = comment;
	}

	public void setComment(Comment comment){
		Association.Voting.linkComment(super.getCitizen(), this, comment);
	}

	void _setComment(Comment comment) {
		this.comment = comment;
	}

	public Comment getComment() {
		return comment;
	}

	@Override
	public void setCitizen(Citizen citizen2) {
		Association.Voting.linkComment(citizen2, this, comment);
	}
}
