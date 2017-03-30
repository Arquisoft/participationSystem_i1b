package es.uniovi.asw.persistence.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("C")
@Table(name="VoteComment")
public class VoteProposal extends Vote{

	@ManyToOne
	private Proposal proposal;
	
	public VoteProposal(Citizen citizen, Proposal prop) {
		super(citizen);
		this.proposal = prop;
	}
	
	public void setProposal(Proposal propuesta){
		Association.Voting.linkProposal(super.getCitizen(), this, propuesta);
	}
	
	void _setProposal(Proposal proposal2) {
		this.proposal=proposal2;
	}
	
	public Proposal getProposal() {
		return proposal;
	}

	@Override
	public void setCitizen(Citizen citizen2) {
			Association.Voting.linkProposal(citizen2, this, proposal);		
	}

}
