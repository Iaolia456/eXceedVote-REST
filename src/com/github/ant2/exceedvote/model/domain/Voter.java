package com.github.ant2.exceedvote.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Voter that represents a person that can vote.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class Voter {

	private String studentId;
	@XmlElement(name="username")
	private String name;

	public Voter() {

	}

	/**
	 * Returns the voter's student ID.
	 * 
	 * @return studentID the voter's student ID.
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * Sets the voter's student ID.
	 * 
	 * @param studentId
	 *            the voter's student ID that is going to be set.
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * Returns the voter's name
	 * 
	 * @return name the voter's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name to this Voter.
	 * 
	 * @param name
	 *            the name that is going to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the number of allowed ballots.
	 * 
	 * @return 3 the number of allowed ballots.
	 */
	//TODO allow ballot still hard code
	public int getAllowedBallots() {
		return 3;
	}

	/**
	 * Returns the message shows the voter's studentID, name, and entity ID.
	 */
	@Override
	public String toString() {
		return "Voter [studentId=" + studentId + ", name=" + name + "]";
	}
}
