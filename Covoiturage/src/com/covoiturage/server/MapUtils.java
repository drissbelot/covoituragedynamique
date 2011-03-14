package com.covoiturage.server;

import java.util.ArrayList;
import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.Query;


import com.covoiturage.server.domain.SimpleTravel;
import com.covoiturage.server.domain.UserInfo;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;



public class MapUtils {

	
	
	public static List<String> bufferRoute(List<String> coordinates, float distance){
		Coordinate[] coordArray=new Coordinate[coordinates.size()];
		int i=0;
		for (String singleCoord : coordinates) {
			Coordinate coord= new Coordinate(Double.parseDouble(singleCoord.substring(singleCoord.indexOf("(")+1,singleCoord.indexOf(",") )),Double.parseDouble(singleCoord.substring(singleCoord.indexOf(",")+1,singleCoord.indexOf(")")-1 )));
			coordArray[i]= coord;
			i++;
		}
		Geometry polyline= new GeometryFactory().createLineString(coordArray);
		
		

		
		
		return passengersInBuffer(polyline.buffer(distance/111));
	}
	public static List<String> passengersInBuffer(Geometry buffer){
		List<String> passengers = new ArrayList<String>();
		EntityManager em = EMF.get().createEntityManager();

		try
		{

			@SuppressWarnings("unchecked")
			List<SimpleTravel> results = em.createQuery("select o from SimpleTravel o").getResultList();
			for (SimpleTravel travel : results) {
				List<String> steps = travel.getSteps();
				int i=0;
				Coordinate[] coordArray=new Coordinate[steps.size()];
				for (String singleCoord : steps) {
					Coordinate coord= new Coordinate(Double.parseDouble(singleCoord.substring(singleCoord.indexOf("(")+1,singleCoord.indexOf(",") )),Double.parseDouble(singleCoord.substring(singleCoord.indexOf(",")+1,singleCoord.indexOf(")")-1 )));
					coordArray[i]= coord;
					i++;	

				}
				if(buffer.contains(new GeometryFactory().createMultiPoint(coordArray))){
					passengers.add(travel.getPassenger());

				}
			}

		}


		finally
		{

			em.close();
		}
		return passengers;


	}

}
