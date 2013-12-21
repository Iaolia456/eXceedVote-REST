package com.github.ant2.exceedvote.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Individual vote to a specific contestant and criterion
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
@XmlRootElement(name="vote")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vote {
	private int id;
	private Criterion criterion;
	@XmlElement(name="user")
	private Voter voter;
	@XmlElement(name="contestant")
	private ContestantScore votedContestant;
	
	public Vote() {
		
	}
	
	/**
	 * Set the score of this vote object
	 * This method is use in constructing the vote to submit to server
	 * @param id id of this vote object
	 * @param criterion criterion that this vote is voted for
	 * @param voter the person who vote
	 * @param score a score given to the contestant
	 */
	public void setVote(int id, Criterion criterion, Voter voter,
			ContestantScore score) {
		this.id = id;
		this.criterion = criterion;
		this.voter = voter;
		this.votedContestant = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Criterion getCriterion() {
		return criterion;
	}

	public void setCriterion(Criterion criterion) {
		this.criterion = criterion;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	public ContestantScore getVotedContestant() {
		return votedContestant;
	}
	
	public void setVotedContestant(ContestantScore contestants) {
		this.votedContestant = contestants;
	}
}
