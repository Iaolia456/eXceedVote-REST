package com.github.ant2.exceedvote.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
	
	public void setVote(int id, Criterion criterion, Voter voter,
			ContestantScore score) {
		this.id = id;
		this.criterion = criterion;
		this.voter = voter;
		
		/*Set<Project> p = map.keySet();
		Project[] projects = p.toArray(new Project[map.size()]);
		for (int i=0; i<map.size(); i++) {*/
//			ContestantScore score = new ContestantScore();
//			score.setProjectId(projects[i].getId());
//			score.setName(projects[i].getName());
//			score.setScore(map.get(projects[i]).intValue());
			this.votedContestant = score;
		//}
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
