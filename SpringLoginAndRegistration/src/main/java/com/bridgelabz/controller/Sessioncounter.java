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

    /**
     * Default constructor. 
     */
	ServletContext sContext = null;
	private static int count;
	public static int getActiveSessions() {
		return count;
	}
    public Sessioncounter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
     	count++;
    	System.out.println("session created");
    
		sContext = se.getSession().getServletContext();
		sContext.setAttribute("count", new Integer(count));
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
