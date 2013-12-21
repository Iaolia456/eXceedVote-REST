package com.github.ant2.exceedvote.model.server;

/**
 * This class contains the eXceedVote server information
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class Server {
	private String APP_URL;
	private int APP_PORT;
	
	public Server(String url, int port) {
		APP_URL = url;
		APP_PORT = port; 
	}
	
	/**
	 * Returns the URL of the server
	 * @return URL of server
	 */
	public String getURL() {
		return APP_URL;
	}
	
	/**
	 * Returns port number that the server is running on
	 * @return port number of server
	 */
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
