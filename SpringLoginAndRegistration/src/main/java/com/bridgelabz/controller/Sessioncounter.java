package com.bridgelabz.controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Sessioncounter
 *
 */
@WebListener
public class Sessioncounter implements HttpSessionListener {

	ServletContext sContext = null;
	private static int count;

	public Sessioncounter() {
	}

	public static int getActiveSessions() {
		return count;
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		count++;
		System.out.println("session created");

		sContext = se.getSession().getServletContext();
		sContext.setAttribute("count", new Integer(count));

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
