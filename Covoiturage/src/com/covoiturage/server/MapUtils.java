package com.covoiturage.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.covoiturage.server.domain.Journey;
import com.covoiturage.server.domain.SimpleTravel;

import com.google.appengine.api.urlfetch.FetchOptions.Builder;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;



public class MapUtils {

	public static List<Journey> bufferRouteJourney(List<String> coordinates, float distance, Date departureStart, Date departureEnd, Date arrival){
		Coordinate[] coordArray=new Coordinate[coordinates.size()];
		int i=0;
		for (String singleCoord : coordinates) {
			Coordinate coord= new Coordinate(Double.parseDouble(singleCoord.substring(singleCoord.indexOf("(")+1,singleCoord.indexOf(",") )),Double.parseDouble(singleCoord.substring(singleCoord.indexOf(",")+1,singleCoord.indexOf(")")-1 )));
			coordArray[i]= coord;
			i++;
		}
		Geometry polyline= new GeometryFactory().createLineString(coordArray);

		return journeyNearBuffer(polyline, distance, departureStart,  departureEnd,  arrival);
	}

	public static List<Journey> journeyNearBuffer(Geometry buffer, float distance, Date departureStart, Date departureEnd, Date arrival){
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		List<Journey> journeys= new ArrayList<Journey>();
		try
		{
			
			@SuppressWarnings("unchecked")
			List<Journey> results = em.createQuery("select o from Journey o").getResultList();
			for (Journey journey : results) {
				List<String> stepsDetails = journey.getStepsDetails();
				if(journey.getWaypoints()!=null)
				stepsDetails.addAll(journey.getWaypoints());
				int i=0;
				Coordinate[] coordArray=new Coordinate[stepsDetails.size()];
				for (String singleCoord : stepsDetails) {
					Coordinate coord= new Coordinate(Double.parseDouble(singleCoord.substring(singleCoord.indexOf("(")+1,singleCoord.indexOf(",") )),Double.parseDouble(singleCoord.substring(singleCoord.indexOf(",")+1,singleCoord.indexOf(")")-1 )));
					coordArray[i]= coord;
					i++;	

				}
				Geometry geom=new GeometryFactory().createLineString(coordArray);
				
				if(geom.buffer(distance/111).contains(buffer)){
					if(journey.getArrival().getTime()<=arrival.getTime()&& journey.getDepartureEnd().getTime()>=departureStart.getTime()){
					journey.getSteps();
					journey.getPassengersTravels();
					journeys.add(journey);
					}
				}
			}
			em.getTransaction().commit();
			em.close();
			return journeys;
			}
			finally{
				
		//		em.close();

			}


	}
	
	
	public static List<SimpleTravel> bufferRoute(List<String> coordinates, Date departureStart, Date departureEnd, Date arrival, float distance){
		Coordinate[] coordArray=new Coordinate[coordinates.size()];
		int i=0;
		for (String singleCoord : coordinates) {
			Coordinate coord= new Coordinate(Double.parseDouble(singleCoord.substring(singleCoord.indexOf("(")+1,singleCoord.indexOf(",") )),Double.parseDouble(singleCoord.substring(singleCoord.indexOf(",")+1,singleCoord.indexOf(")")-1 )));
			coordArray[i]= coord;
			i++;
			
		}
		
		Geometry polyline= new GeometryFactory().createLineString(coordArray);
		return simpleTravelsInBuffer(coordArray,polyline.buffer(distance/111),departureStart,  departureEnd,  arrival);
	}
	
	public static List<SimpleTravel> simpleTravelsInBuffer(Coordinate[] array,Geometry buffer, Date departureStart, Date departureEnd, Date arrival){
		
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

					try{
						URL url = new URL("http://routes.cloudmade.com/8ee2a50541944fb9bcedded5165f09d9/api/0.3/"+array[0].x+","+array[0].y+",%5B"+coordArray[0].x+","+coordArray[0].y+","+coordArray[coordArray.length-1].x+","+coordArray[coordArray.length-1].y+"%5D,"+array[array.length-1].x+","+array[array.length-1].y+"/car/shortest.js");
			
						
					//URL url = new URL("http://openrouteservice.org/index.php?start="+array[0].y+","+array[0].x+"&end="+array[array.length-1].y+","+array[array.length-1].x+"&via="+coordArray[0].y+","+coordArray[0].x+"%20"+coordArray[coordArray.length-1].y+","+coordArray[coordArray.length-1].x+"&pref=Fastest&lang=en");
						
				   
				 
				   
				   BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				   String line;
				   JSONValue jsonValue;
		            while ((line = reader.readLine()) != null) {
		            	//Logger.getLogger("").warning()
		            }
		            
		            reader.close();

					
		        
		            		          

					}catch (MalformedURLException e) {
			            
			        } catch (IOException e) {
			           
			        }
					
					if(travel.getArrival().getTime()<=arrival.getTime()&& travel.getDepartureStart().getTime()<=departureEnd.getTime())
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
