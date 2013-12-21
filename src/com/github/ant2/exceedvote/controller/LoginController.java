package com.github.ant2.exceedvote.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.ant2.exceedvote.activity.controller.WelcomeActivity;
import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.exceedvote.model.process.LoginProcess;
import com.github.ant2.exceedvote.model.process.LoginResult;
import com.github.ant2.exceedvote.view.LoginWindow;
import com.github.ant2.exceedvote.view.MainView;
import com.github.ant2.ui.activity.Activity;

/**
 * A controller that controls the login process.
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class LoginController {

	private LoginProcess process;
	private LoginWindow window;
	private Runnable logoutAction = new Runnable() {
		@Override
		public void run() {
			displayLoginWindow();
		}
	};

	/**
	 * Constructs a new LoginController
	 * 
	 * @param process
	 *            the process to control
	 * @param window
	 *            the window to control
	 */
	public LoginController(LoginProcess process, LoginWindow window) {
		this.process = process;
		this.window = window;

		window.getLoginButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doLogin();
			}
		});

		window.getResetButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetField();
			}
		});
	}

	/**
	 * Runs the controller.
	 */
	public void run() {
		displayLoginWindow();
	}

	//After login code here
	private void doLogin() {
		LoginResult result = process.login(window.getUsernameField().getText(),
				new String(window.getPasswordField().getPassword()));
		if (result.getStatus() != LoginResult.Status.SUCCESS) {
			window.showLoginError();
			return;
		}
		// window.dispose();
		window.setVisible(false);
		startMain(result);
	}

	private void displayLoginWindow() {
		window.setVisible(true);
		resetField();
	}

	private void startMain(LoginResult result) {
		Context context = process.getContext(result);

		MainView mainView = new MainView();
		MainController mainController = new MainController(context,
				mainView);
		Activity activity;

		mainController.setOnLogoutAction(logoutAction);

		activity = new WelcomeActivity(context, new WelcomeActivityView());
		mainController.run(activity);
	}

	private void resetField() {
		window.getUsernameField().setText("");
		window.getPasswordField().setText("");
	}

}
