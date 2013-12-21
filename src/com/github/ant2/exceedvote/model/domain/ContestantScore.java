package com.github.ant2.exceedvote.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Individual score for one contestant
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
@XmlRootElement(name="contestant")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContestantScore {
	@XmlElement(name="id")
	private int projectId;
	private String name;
	private int score;
	
	public ContestantScore() {
		
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
