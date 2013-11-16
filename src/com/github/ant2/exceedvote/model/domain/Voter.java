package com.github.ant2.exceedvote.model.domain;


/**
 * The Voter that represents a person that can vote.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class Voter implements VoteEvent.Part {

	private String studentId;
	private String name;

	private User user;

	private VoteEvent voteEvent;

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
	 * Returns the VoteEvent for this voter.
	 * 
	 * @return voteEvent the VoteEvent for this voter.
	 */
	@Override
	public VoteEvent getVoteEvent() {
		return voteEvent;
	}

	/**
	 * Sets the VoteEvent for this voter.
	 * 
	 * @param voteEvent
	 *            the VoteEvent that is going to be set.
	 */
	public void setVoteEvent(VoteEvent voteEvent) {
		this.voteEvent = voteEvent;
	}

	/**
	 * Returns the number of allowed ballots.
	 * 
	 * @return 3 the number of allowed ballots.
	 */
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

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
