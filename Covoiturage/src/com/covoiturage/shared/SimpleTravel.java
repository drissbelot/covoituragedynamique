package com.covoiturage.shared;

import java.io.Serializable;
import java.util.List;

	
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;




@PersistenceCapable
public class SimpleTravel implements Serializable {

	private static final long serialVersionUID = 1L;
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	public Long id;
	@Persistent
	public List<String> steps;



	public SimpleTravel() {}

	public SimpleTravel(Long id,  List<String> steps) {

		this.id = id;
		this.steps = steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
		
	}}
