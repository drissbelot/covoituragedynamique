package com.covoiturage.server;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.covoiturage.server.domain.SimpleTravel;

public class ImageServiceImpl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em = EMF.get().createEntityManager();
		Query query = em
				.createQuery("select o from SimpleTravel o where o.passenger = :idParam");
		query.setParameter("idParam", request.getParameter("id"));
		SimpleTravel travel;

		try {

			travel = (SimpleTravel) query.getResultList().get(0);
		} finally {
			em.close();
		}
		response.reset();
		response.setContentType(travel.getMapImageType());

		ServletOutputStream os = response.getOutputStream();

		os.write(travel.getMapImage());

	}
}
