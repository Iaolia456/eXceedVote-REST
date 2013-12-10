package com.github.ant2.exceedvote.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Vote {
	private int id;
	private Criterion criterion;
	@XmlElement(name="username")
	private Voter voter;
	@XmlElement(name="contestants")
	List<ContestantScore> votedContestants;
	
	public Vote() {
		votedContestants = new ArrayList<ContestantScore>();
	}
	
	public void setVote(int id, Criterion criterion, Voter voter,
			Map<Project, Integer> map) {
		this.id = id;
		this.criterion = criterion;
		this.voter = voter;
		
		Set<Project> p = map.keySet();
		Project[] projects = p.toArray(new Project[map.size()]);
		for (int i=0; i<map.size(); i++) {
			ContestantScore score = new ContestantScore();
			score.setProjectId(projects[i].getId());
			score.setScore(map.get(projects[i]).intValue());
			votedContestants.add(score);
		}
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

	public List<ContestantScore> getVotedContestants() {
		return votedContestants;
	}

	public void setVotedContestants(List<ContestantScore> votedContestants) {
		this.votedContestants = votedContestants;
	}
}
