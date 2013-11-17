package com.github.ant2.exceedvote.model.server;

public class Server {
	private String APP_URL;
	private int APP_PORT;
	
	public Server(String url, int port) {
		APP_URL = url;
		APP_PORT = port; 
	}
	
	public String getURL() {
		return APP_URL;
	}
	
	public int getPort() {
		return APP_PORT;
	}
	
	public void setURL(String url) {
		APP_URL = url;
	}
	
	public void setPort(int port) {
		APP_PORT = port;
	}
}
