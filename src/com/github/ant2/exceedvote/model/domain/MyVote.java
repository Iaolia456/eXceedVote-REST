package com.github.ant2.exceedvote.model.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="myvote")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyVote {
	@XmlElement(name="vote")
	private List<Vote> votes;
	
	public MyVote() {
		
	}
	
	public List<Vote> getVotes() {
		return votes;
	}
	
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
}
