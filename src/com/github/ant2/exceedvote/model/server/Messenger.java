package com.github.ant2.exceedvote.model.server;

public class Messenger {
	private static Server server;
	
	private Messenger() {
		
	}
	
	public static Server getServer() {
		return server;
	}
	
	public static void setServer(Server server) {
		Messenger.server = server;
	}
	
	//TODO snedMessage method
	public static void sendMessage() {
		
	}
}
