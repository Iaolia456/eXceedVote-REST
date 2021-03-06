package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * A login result process
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class LoginResult {
	private Status status;
	private Voter voter;

	/**
	 * The status of the login
	 * 
	 * @author Thiwat Rongsirigul (Leo Aiolia)
	 */
	public enum Status {
		/** Login success */
		SUCCESS,

		/** Login failure */
		FAILURE;
	}

	/**
	 * Sets the status to the LoginResult
	 * 
	 * @param status
	 *            the status that is set
	 */
	public LoginResult(Status status) {
		this.status = status;
	}

	/**
	 * Sets the voter
	 * 
	 * @param voter
	 *            the voter that is set
	 */
	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	/**
	 * Gets the status
	 * 
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Gets the voter
	 * 
	 * @return the voter
	 */
	public Voter getVoter() {
		return voter;
	}

	@Override
	public String toString() {
		return status.toString();
	}

}
