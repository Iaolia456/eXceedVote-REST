package com.github.ant2.exceedvote.model.server;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.Filterable;

public class Messenger {
	private static Client client;
	private static Server server;
	
	static {
		client = Client.create();
	}
	
	private Messenger() {
		
	}
	
	public static Server getServer() {
		return server;
	}
	
	public static void setServer(Server server) {
		Messenger.server = server;
	}
	
	public static WebResource createWebResource(String path) {
		UriBuilder builder = UriBuilder.fromUri(server.getURL()).port(server.getPort());
		URI uri = builder.build();
		System.out.println(uri.toString());
		return client.resource(uri).path(path);
	}

	public static Filterable getClient() {
		return client;
	}
}
