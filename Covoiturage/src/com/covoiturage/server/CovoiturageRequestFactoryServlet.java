package com.covoiturage.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.covoiturage.server.domain.UserInfo;
import com.google.gwt.requestfactory.server.RequestFactoryServlet;

public class CovoiturageRequestFactoryServlet extends RequestFactoryServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        if (! userIsLoggedIn(req))
        {
            throw new ServletException("not logged in");
        }
        else
        {
            super.doPost(req, res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        if (! userIsLoggedIn(req))
        {
            throw new ServletException("not logged in");
        }
        else
        {
            super.doGet(req, res);
        }
    }

    protected boolean userIsLoggedIn(HttpServletRequest req){
        
        String user = (String) req.getSession().getAttribute("LOGGED_IN_USER");
        return user != null;
    }
}
