package com.github.ant2.exceedvote.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Used in constructing the XML to matched the server's api
 * A wrapper class of votes casted by voter
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
@XmlRootElement(name="vote")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoteToSubmit {
	@XmlElementWrapper(name="contestants")
	List<ContestantScore> contestant;
	
	public VoteToSubmit() {
		contestant = new ArrayList<ContestantScore>();
	}
	
	public List<ContestantScore> getContestant() {
		return contestant;
	}
	
	public void setContestant(List<ContestantScore> contestant) {
		this.contestant = contestant;
	}

	public void setVote(List<Vote> votes) {
		for (Vote v : votes) {
			contestant.add(v.getVotedContestant());
		}
	}
}
