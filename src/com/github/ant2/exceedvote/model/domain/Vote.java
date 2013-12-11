package com.github.ant2.exceedvote.model.domain;

import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vote")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vote {
	private int id;
	private Question criterion;
	@XmlElement(name="user")
	private Voter voter;
	@XmlElement(name="contestants")
	private Contestants votedContestant;
	
	public Vote() {
		//TODO cannot handle multiple <vote> in one file (when using /myvote)
	}
	
	public void setVote(int id, Question criterion, Voter voter,
			Map<Project, Integer> map) {
		this.id = id;
		this.criterion = criterion;
		this.voter = voter;
		
		Set<Project> p = map.keySet();
		Project[] projects = p.toArray(new Project[map.size()]);
		votedContestant = new Contestants();
		for (int i=0; i<map.size(); i++) {
			ContestantScore score = new ContestantScore();
			score.setProjectId(projects[i].getId());
			score.setName(projects[i].getName());
			score.setScore(map.get(projects[i]).intValue());
			votedContestant.getContestants().add(score);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return criterion;
	}

	public void setQuestion(Question criterion) {
		this.criterion = criterion;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	public Contestants getVotedContestants() {
		return votedContestant;
	}
	
	public void setVotedContestants(Contestants contestants) {
		this.votedContestant = contestants;
	}
}
