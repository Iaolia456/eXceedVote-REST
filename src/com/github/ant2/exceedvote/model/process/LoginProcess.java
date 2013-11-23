
package com.github.ant2.exceedvote.model.process;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.model.server.Messenger;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPDigestAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;

/**
 * A login process
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class LoginProcess {
	private DaoFactory sd;
	private VoterDao voterDao;
	private Client client;
	private String APP_URL;
	private int APP_PORT;

	/**
	 * @param sd
	 *            the DAOFactory
	 */
	public LoginProcess(DaoFactory sd) {
		client = Client.create();
		this.APP_URL = Messenger.getServer().getURL();
		this.APP_PORT = Messenger.getServer().getPort();
		this.sd = sd;
		voterDao = sd.getVoterDao();
	}

	public WebResource createWebResource(String path) {
		UriBuilder builder = UriBuilder.fromUri(APP_URL).port(APP_PORT);
		URI uri = builder.build();
		System.out.println(uri.toString());
		return client.resource(uri).path(path);
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
		client.addFilter(new LoggingFilter(System.out));
		HTTPDigestAuthFilter authFilter = new HTTPDigestAuthFilter(user, password);
		client.addFilter(authFilter);
		
		WebResource res = createWebResource("/");
		ClientResponse resp = null;
		try {
			resp = res.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new LoginResult(LoginResult.Status.FAILURE);
		}
		
		if (resp.getStatus() == 200) return new LoginResult(LoginResult.Status.SUCCESS);
		else {
			System.out.println("Server returned: " + resp.getStatus());
			client.removeFilter(authFilter);
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
