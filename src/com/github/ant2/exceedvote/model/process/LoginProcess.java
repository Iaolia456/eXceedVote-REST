
package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * A login process
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class LoginProcess {
	private DaoFactory sd;
	private VoterDao voterDao;

	/**
	 * @param sd
	 *            the DAOFactory
	 */
	public LoginProcess(DaoFactory sd) {
		this.sd = sd;
		voterDao = sd.getVoterDao();
	}

	/**
	 * Logins the system
	 * 
	 * @param user
	 *            the login user
	 * @param pass
	 *            the user's password
	 * @return the login result
	 */
	//TODO login code here
	public LoginResult login(String user, String pass) {
		return new LoginResult(LoginResult.Status.FAILURE);
	}

	/**
	 * Gets the context
	 * 
	 * @param result
	 *            the result of login
	 * @return the context contains the result
	 */
	public Context getContext(LoginResult result) {
		Voter voter = result.getVoter();
		if (voter == null) return null;
		return new Context(sd, voter.getVoteEvent(), voter);
	}

	/**
	 * Gets the DAOFactory
	 * 
	 * @return the DAOFactory
	 */
	public DaoFactory getDaoFactory() {
		return sd;
	}
}
