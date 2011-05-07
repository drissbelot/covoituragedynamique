/*
 * 
 */
package com.covoiturage.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.covoiturage.server.domain.Journey;
import com.covoiturage.server.domain.SimpleTravel;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageServiceImpl.
 */
public class ImageServiceImpl extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Objectify ofy = ObjectifyService.begin();
		if (request.getParameter("class").contains("SimpleTravel")) {
			SimpleTravel travel;
			travel = ofy.find(SimpleTravel.class,
					Long.valueOf(request.getParameter("id")));

			response.reset();
			response.setContentType(travel.getMapImageType());

			ServletOutputStream os = response.getOutputStream();

			os.write(travel.getMapImage());
		} else if (request.getParameter("class").contains("Journey")) {
			Journey journey;
			journey = ofy.find(Journey.class,
					Long.valueOf(request.getParameter("id")));

			response.reset();
			response.setContentType(journey.getMapImageType());

			ServletOutputStream os = response.getOutputStream();

			os.write(journey.getMapImage());
		}

	}
}
