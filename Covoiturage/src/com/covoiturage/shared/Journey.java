package com.covoiturage.shared;

import java.io.Serializable;
import java.util.List;

	
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.maps.client.geom.LatLng;



@PersistenceCapable
@SuppressWarnings("serial")
public class Journey implements Serializable{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	public Long id;
	@Persistent
	public UserInfo driver;
	@Persistent
	public List<UserInfo> passengers;
	@Persistent
	public List<LatLng> steps;



	public Journey() {}

	public Journey(Long id, UserInfo driver, List<UserInfo> passengers, List<LatLng> steps) {
		super();
		this.id = id;
		this.driver = driver;
		this.passengers = passengers;
		this.steps = steps;
	}}
