package com.covoiturage.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.covoiturage.server.domain.Journey;
import com.covoiturage.server.domain.SimpleTravel;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;



public class MapUtils {

	public static List<Journey> bufferRouteJourney(List<String> coordinates, float distance){
		Coordinate[] coordArray=new Coordinate[coordinates.size()];
		int i=0;
		for (String singleCoord : coordinates) {
			Coordinate coord= new Coordinate(Double.parseDouble(singleCoord.substring(singleCoord.indexOf("(")+1,singleCoord.indexOf(",") )),Double.parseDouble(singleCoord.substring(singleCoord.indexOf(",")+1,singleCoord.indexOf(")")-1 )));
			coordArray[i]= coord;
			i++;
		}
		Geometry polyline= new GeometryFactory().createLineString(coordArray);
		return journeyNearBuffer(polyline, distance);
	}

	public static List<Journey> journeyNearBuffer(Geometry buffer, float distance){
		EntityManager em = EMF.get().createEntityManager();
		List<Journey> journeys= new ArrayList<Journey>();
		try
		{

			@SuppressWarnings("unchecked")
			List<Journey> results = em.createQuery("select o from Journey o").getResultList();
			for (Journey journey : results) {
				List<String> steps = journey.getStepsDetails();
				if(journey.getWaypoints()!=null)
				steps.addAll(journey.getWaypoints());
				int i=0;
				Coordinate[] coordArray=new Coordinate[steps.size()];
				for (String singleCoord : steps) {
					Coordinate coord= new Coordinate(Double.parseDouble(singleCoord.substring(singleCoord.indexOf("(")+1,singleCoord.indexOf(",") )),Double.parseDouble(singleCoord.substring(singleCoord.indexOf(",")+1,singleCoord.indexOf(")")-1 )));
					coordArray[i]= coord;
					i++;	

				}
				Geometry geom=new GeometryFactory().createLineString(coordArray);
				
				if(geom.buffer(distance/111).contains(buffer)){
					journeys.add(journey);
					
				}
			}
			}
			finally{
				em.close();
				
			}
			return journeys;
	}
	
	
	public static List<SimpleTravel> bufferRoute(List<String> coordinates, float distance){
		Coordinate[] coordArray=new Coordinate[coordinates.size()];
		int i=0;
		for (String singleCoord : coordinates) {
			Coordinate coord= new Coordinate(Double.parseDouble(singleCoord.substring(singleCoord.indexOf("(")+1,singleCoord.indexOf(",") )),Double.parseDouble(singleCoord.substring(singleCoord.indexOf(",")+1,singleCoord.indexOf(")")-1 )));
			coordArray[i]= coord;
			i++;
		}
		Geometry polyline= new GeometryFactory().createLineString(coordArray);
		return simpleTravelsInBuffer(polyline.buffer(distance/111));
	}
	
	public static List<SimpleTravel> simpleTravelsInBuffer(Geometry buffer){
		EntityManager em = EMF.get().createEntityManager();
		List<SimpleTravel> simpleTravels= new ArrayList<SimpleTravel>();
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
					simpleTravels.add(travel);
					
				}
			}
			}
			finally{
				em.close();
				
			}
			return simpleTravels;
	}
	


}
