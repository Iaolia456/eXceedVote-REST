
package com.github.ant2.exceedvote.model.process;

import javax.ws.rs.core.MediaType;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.model.server.Messenger;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPDigestAuthFilter;

/**
 * A login process
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class LoginProcess {
	private DaoFactory sd;

	/**
	 * @param sd
	 *            the DAOFactory
	 */
	public LoginProcess(DaoFactory sd) {
		this.sd = sd;
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
	public LoginResult login(String user, String password) {
		//Messenger.getClient().addFilter(new LoggingFilter(System.out));
		HTTPDigestAuthFilter authFilter = new HTTPDigestAuthFilter(user, password);
		Messenger.getClient().addFilter(authFilter);
		
		WebResource res = Messenger.createWebResource("api/v1/contestant");
		ClientResponse resp = null;
		try {
			resp = res.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new LoginResult(LoginResult.Status.FAILURE);
		}
		
		if (resp.getStatus() == 200) {
			LoginResult result = new LoginResult(LoginResult.Status.SUCCESS);
			Voter voter = new Voter();
			voter.setName("Voter");
			result.setVoter(voter);
			return result;
		}
		else {
			System.out.println("Server returned: " + resp.getStatus());
			Messenger.getClient().removeFilter(authFilter);
			return new LoginResult(LoginResult.Status.FAILURE);
		}
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
		return new Context(sd, voter);
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
