package com.github.ant2.exceedvote.model.server;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.Filterable;

/**
 * This class handles the communication with RESTful server
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class Messenger {
	private static Client client;
	private static Server server;
	
	static {
		client = Client.create();
	}
	
	private Messenger() {
		
	}
	
	/**
	 * Return the server information
	 * @return server information
	 */
	public static Server getServer() {
		return server;
	}
	
	public static void setServer(Server server) {
		Messenger.server = server;
	}
	
	/**
	 * Create web resource for using in RESTful services
	 * @param path URI of the resource
	 * @return web resource onject
	 */
	public static WebResource createWebResource(String path) {
		UriBuilder builder = UriBuilder.fromUri(server.getURL()).port(server.getPort());
		URI uri = builder.build();
		System.out.println(uri.toString());
		return client.resource(uri).path(path);
	}

	/**
	 * Returns the Jersey's client object
	 * @return Jersey's client object
	 */
	public static Filterable getClient() {
		return client;
	}
}
