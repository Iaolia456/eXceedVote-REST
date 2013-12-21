package com.github.ant2.exceedvote.model.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Root element that wrapped the "vote" information
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
@XmlRootElement(name="myvote")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyVote {
	@XmlElementWrapper(name="votes")
	private List<Vote> vote;
	
	public MyVote() {
		
	}
	
	public List<Vote> getVotes() {
		return vote;
	}
	
	public void setVotes(List<Vote> votes) {
		this.vote = votes;
	}
}
