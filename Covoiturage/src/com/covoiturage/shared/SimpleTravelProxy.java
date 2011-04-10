package com.covoiturage.shared;

import java.util.Date;
import java.util.List;



import com.covoiturage.server.domain.SimpleTravel;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.ProxyFor;






@ProxyFor(SimpleTravel.class)
public interface SimpleTravelProxy extends EntityProxy{

	public Date getDate();

	public void setDate(Date date);

	public List<String> getSteps();

	public String getOriginAddress();
	 public String getDestinationAddress();

	public String getPassenger();

	public void setPassenger(String passenger);

	
	public void setSteps(List<String> steps);
	
	EntityProxyId<SimpleTravelProxy> stableId();
	public Date getDepartureStart();

	public void setDepartureStart(Date departureStart);

	public Date getDepartureEnd();

	public void setDepartureEnd(Date departureEnd);

	public Date getArrival();

	public void setArrival(Date arrival);
	public Long getId();
	
	public String getStatusPassenger();

	public void setStatusPassenger(String statusPassenger);

	public String getStatusDriver();

	public void setStatusDriver(String statusDriver) ;
	public String getMapImageType();

	public void setMapImageType(String mapImageType);
	public void setMapImage(byte[] mapImage);

	public byte[] getMapImage();
	
}
