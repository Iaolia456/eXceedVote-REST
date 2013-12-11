package com.github.ant2.exceedvote.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Contestants {
	@XmlElement(name="contestant")
	private List<ContestantScore> contestants;
	
	public Contestants() {
		contestants = new ArrayList<ContestantScore>();
	}
	
	public List<ContestantScore> getContestants() {
		return contestants;
	}
	
	public void setContestants(List<ContestantScore> contestants) {
		this.contestants = contestants;
	}
}
