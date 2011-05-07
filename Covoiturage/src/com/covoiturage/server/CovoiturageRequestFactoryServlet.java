/*
 * 
 */
package com.covoiturage.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

// TODO: Auto-generated Javadoc
/**
 * The Class CovoiturageRequestFactoryServlet.
 */
public class CovoiturageRequestFactoryServlet extends RequestFactoryServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.google.web.bindery.requestfactory.server.RequestFactoryServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		if (!userIsLoggedIn(req) && !req.toString().contains("AddUser")) {
			throw new ServletException("not logged in");
		} else {
			super.doPost(req, res);
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		if (!userIsLoggedIn(req)) {
			throw new ServletException("not logged in");
		} else {
			super.doGet(req, res);
		}
	}

	/**
	 * User is logged in.
	 *
	 * @param req the req
	 * @return true, if successful
	 */
	protected boolean userIsLoggedIn(HttpServletRequest req) {

		String user = (String) req.getSession().getAttribute("LOGGED_IN_USER");
		return user != null;
	}
}
