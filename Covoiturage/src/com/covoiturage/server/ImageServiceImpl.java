package com.covoiturage.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.covoiturage.server.domain.SimpleTravel;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class ImageServiceImpl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Objectify ofy=  ObjectifyService.begin();
		SimpleTravel travel;
		travel= ofy.query(SimpleTravel.class).filter("passenger", request.getParameter("id")).get();

		


		response.reset();
		response.setContentType(travel.getMapImageType());

		ServletOutputStream os = response.getOutputStream();

		os.write(travel.getMapImage());

	}
}
