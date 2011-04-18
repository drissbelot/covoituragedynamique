package com.covoiturage.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.covoiturage.server.domain.Journey;
import com.covoiturage.server.domain.SimpleTravel;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

public class MapUtils {
	// TODO gérer le cas où la personne ne répond pas...
	public static List<Journey> bufferRouteJourney(List<String> coordinates,
			float distance, Date departureStart, Date departureEnd, Date arrival) {
		Coordinate[] coordArray = new Coordinate[coordinates.size()];
		int i = 0;
		for (String singleCoord : coordinates) {
			Coordinate coord = new Coordinate(Double.parseDouble(singleCoord
					.substring(singleCoord.indexOf("(") + 1,
							singleCoord.indexOf(","))),
					Double.parseDouble(singleCoord.substring(
							singleCoord.indexOf(",") + 1,
							singleCoord.indexOf(")") - 1)));
			coordArray[i] = coord;
			i++;
		}
		Geometry polyline = new GeometryFactory().createLineString(coordArray);

		return journeyNearBuffer(polyline, distance, departureStart,
				departureEnd, arrival);
	}

	public static List<Journey> journeyNearBuffer(Geometry buffer,
			float distanceJourney, Date departureStart, Date departureEnd,
			Date arrival) {
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		List<Journey> journeys = new ArrayList<Journey>();
		try {

			@SuppressWarnings("unchecked")
			List<Journey> results = em.createQuery("select o from Journey o")
					.getResultList();
			for (Journey journey : results) {
				List<String> stepsDetails = journey.getStepsDetails();
				Coordinate[] arrayWaypoints = null;
				if (journey.getWaypoints() != null) {
					stepsDetails.addAll(journey.getWaypoints());
					arrayWaypoints = new Coordinate[journey.getWaypoints()
							.size()];
					int k = 0;
					for (String singleCoord : journey.getWaypoints()) {
						Coordinate coord = new Coordinate(
								Double.parseDouble(singleCoord.substring(
										singleCoord.indexOf("(") + 1,
										singleCoord.indexOf(","))),
								Double.parseDouble(singleCoord.substring(
										singleCoord.indexOf(",") + 1,
										singleCoord.indexOf(")") - 1)));
						arrayWaypoints[k] = coord;
						k++;
					}
				}
				int i = 0;
				Coordinate[] coordArray = new Coordinate[stepsDetails.size()];
				for (String singleCoord : stepsDetails) {
					Coordinate coord = new Coordinate(
							Double.parseDouble(singleCoord.substring(
									singleCoord.indexOf("(") + 1,
									singleCoord.indexOf(","))),
							Double.parseDouble(singleCoord.substring(
									singleCoord.indexOf(",") + 1,
									singleCoord.indexOf(")") - 1)));
					coordArray[i] = coord;
					i++;

				}
				List<String> steps = journey.getSteps();
				int j = 0;
				Coordinate[] array = new Coordinate[steps.size()];
				for (String singleCoord : steps) {
					Coordinate coord = new Coordinate(
							Double.parseDouble(singleCoord.substring(
									singleCoord.indexOf("(") + 1,
									singleCoord.indexOf(","))),
							Double.parseDouble(singleCoord.substring(
									singleCoord.indexOf(",") + 1,
									singleCoord.indexOf(")") - 1)));
					array[j] = coord;
					j++;

				}
				Geometry geom = new GeometryFactory()
						.createLineString(coordArray);

				if (geom.buffer(distanceJourney / 111).contains(buffer)) {
					float distance = 0;
					float duration = 0;
					try {
						String urlString = "http://routes.cloudmade.com/8ee2a50541944fb9bcedded5165f09d9/api/0.3/"
								+ array[0].x + "," + array[0].y + ",%5B";
						for (int l = 0; l < arrayWaypoints.length; l++) {
							urlString += arrayWaypoints[l].x + ","
									+ arrayWaypoints[l].y + ",";
						}
						urlString = urlString.substring(0,
								urlString.length() - 2);
						urlString += "%5D," + array[array.length - 1].x + ","
								+ array[array.length - 1].y
								+ "/car/fastest.gpx";
						URL url = new URL(urlString);
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(url.openStream()));
						String line;
						if ((line = reader.readLine()) != null) {
							line = line.substring(line.indexOf("distance") + 9);
							distance = Float.valueOf(line.substring(0,
									line.indexOf("<")));
							line = line.substring(line.indexOf("time") + 5);
							duration = Float.valueOf(line.substring(0,
									line.indexOf("<")));
						}
					} catch (MalformedURLException e) {

					} catch (IOException e) {

					}
					if (journey.getArrival().getTime() <= arrival.getTime()
							&& journey.getDepartureEnd().getTime() >= departureStart
									.getTime()
							&& distance <= distanceJourney
							&& (new Date(journey.getDepartureStart().getTime()
									+ (long) (duration * 1000))).getTime() <= journey
									.getArrival().getTime()) {
						journey.getSteps();
						journey.getPassengersTravels();
						journeys.add(journey);

					}
				}
			}
			em.getTransaction().commit();

			return journeys;
		} finally {
			em.close();
		}
	}

	public static List<SimpleTravel> bufferRoute(List<String> coordinates,
			Date departureStart, Date departureEnd, Date arrival, float distance) {
		Coordinate[] coordArray = new Coordinate[coordinates.size()];
		int i = 0;
		for (String singleCoord : coordinates) {
			Coordinate coord = new Coordinate(Double.parseDouble(singleCoord
					.substring(singleCoord.indexOf("(") + 1,
							singleCoord.indexOf(","))),
					Double.parseDouble(singleCoord.substring(
							singleCoord.indexOf(",") + 1,
							singleCoord.indexOf(")") - 1)));
			coordArray[i] = coord;
			i++;

		}

		Geometry polyline = new GeometryFactory().createLineString(coordArray);
		return simpleTravelsInBuffer(coordArray,
				polyline.buffer(distance / 111), departureStart, departureEnd,
				arrival, distance);
	}

	public static List<SimpleTravel> simpleTravelsInBuffer(Coordinate[] array,
			Geometry buffer, Date departureStart, Date departureEnd,
			Date arrival, float distanceJourney) {

		EntityManager em = EMF.get().createEntityManager();
		List<SimpleTravel> simpleTravels = new ArrayList<SimpleTravel>();
		try {

			@SuppressWarnings("unchecked")
			List<SimpleTravel> results = em.createQuery(
					"select o from SimpleTravel o").getResultList();
			for (SimpleTravel travel : results) {
				List<String> steps = travel.getSteps();
				int i = 0;
				Coordinate[] coordArray = new Coordinate[steps.size()];
				for (String singleCoord : steps) {
					Coordinate coord = new Coordinate(
							Double.parseDouble(singleCoord.substring(
									singleCoord.indexOf("(") + 1,
									singleCoord.indexOf(","))),
							Double.parseDouble(singleCoord.substring(
									singleCoord.indexOf(",") + 1,
									singleCoord.indexOf(")") - 1)));
					coordArray[i] = coord;
					i++;

				}
				if (buffer.contains(new GeometryFactory()
						.createMultiPoint(coordArray))) {
					float distance = 0;
					float duration = 0;
					try {
						URL url = new URL(
								"http://routes.cloudmade.com/8ee2a50541944fb9bcedded5165f09d9/api/0.3/"
										+ array[0].x + "," + array[0].y
										+ ",%5B" + coordArray[0].x + ","
										+ coordArray[0].y + ","
										+ coordArray[coordArray.length - 1].x
										+ ","
										+ coordArray[coordArray.length - 1].y
										+ "%5D," + array[array.length - 1].x
										+ "," + array[array.length - 1].y
										+ "/car/fastest.gpx");
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(url.openStream()));
						String line;

						if ((line = reader.readLine()) != null) {
							line = line.substring(line.indexOf("distance") + 9);
							distance = Float.valueOf(line.substring(0,
									line.indexOf("<")));
							line = line.substring(line.indexOf("time") + 5);
							duration = Float.valueOf(line.substring(0,
									line.indexOf("<")));
						}
					} catch (MalformedURLException e) {

					} catch (IOException e) {

					}

					if (travel.getArrival().getTime() <= arrival.getTime()
							&& travel.getDepartureStart().getTime() <= departureEnd
									.getTime()
							&& distance <= distanceJourney
							&& (new Date(departureStart.getTime()
									+ (long) (duration * 1000))).getTime() <= arrival
									.getTime())
						simpleTravels.add(travel);
				}

			}
		} finally {
			em.close();

		}
		return simpleTravels;
	}

}
