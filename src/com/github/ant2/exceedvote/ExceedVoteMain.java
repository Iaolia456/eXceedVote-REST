package com.github.ant2.exceedvote;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.controller.LoginController;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.restful.RestDaoFactory;
import com.github.ant2.exceedvote.model.process.LoginProcess;
import com.github.ant2.exceedvote.model.server.Messenger;
import com.github.ant2.exceedvote.model.server.Server;
import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.exceedvote.view.LoginWindow;

/**
 * eXceed Vote Main Class
 * 
 * @author dtinth
 */
public class ExceedVoteMain {

	private static Logger logger = LogManager.getLogger(ExceedVoteMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info("eXceed Vote Starting...");

		UIUtility.setTheme();

		DaoFactory df = new RestDaoFactory();
		//Server server = new Server("http://158.108.228.54", 8080);
		Server server = new Server("http://localhost", 9000);
		Messenger.setServer(server);

		LoginProcess loginProcess = new LoginProcess(df);
		LoginWindow window = new LoginWindow();

		LoginController controller = new LoginController(loginProcess, window);
		
		controller.run();

	}

}
