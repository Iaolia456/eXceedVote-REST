package com.github.ant2.exceedvote.model.domain;

import javax.xml.bind.annotation.*;


/**
 * A criterion which voter can vote for.
 * 
 * @author Artima Mahahemarat
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Criterion implements VoteEvent.Part {
	@XmlElement(name="name")
	/** criterion name */
	private String name;

	private VoteEvent voteEvent;

	/**
	 * Constructs a criterion.
	 */
	public Criterion() {
	}

	/**
	 * Returns criterion name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets criterion name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public VoteEvent getVoteEvent() {
		return voteEvent;
	}

	public void setVoteEvent(VoteEvent voteEvent) {
		this.voteEvent = voteEvent;
	}
}
