package com.covoiturage.server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.VehicleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import au.com.bytecode.opencsv.CSVReader;

public class VehicleServiceImpl extends RemoteServiceServlet implements VehicleService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String[]> 	entriesMakes = new ArrayList<String[]>();
	private List<String[]> 	entriesModels = new ArrayList<String[]>();
	private List<String[]> 	entriesYears = new ArrayList<String[]>();

	public void parseDatabaseMakes(){
	
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(getServletContext().getRealPath("")+"/Makes.csv"));
		} catch (FileNotFoundException e1) {
				System.out.println(e1.getStackTrace());
		}
		try {
			entriesMakes=reader.readAll();
		} catch (IOException e) {


		}

	}
	public void parseDatabaseModels(String make){
		
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(getServletContext().getRealPath("")+"/"+make+".csv"));
		} catch (FileNotFoundException e1) {
				System.out.println(e1.getStackTrace());
		}
		try {
			entriesModels=reader.readAll();
		} catch (IOException e) {


		}

	}
	public void parseDatabaseYears(){
		
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(getServletContext().getRealPath("")+"/Years.csv"));
		} catch (FileNotFoundException e1) {
				System.out.println(e1.getStackTrace());
		}
		try {
			entriesYears=reader.readAll();
		} catch (IOException e) {


		}

	}

	public List<String> getModels(String model, String make){
		List<String> models = new ArrayList<String>();
		if(entriesModels!=null){
			parseDatabaseModels(make.replace(" ", "_"));

		}
		
		for (String[] entry : entriesModels) {
			models.add(entry[0]);
		}
		return models;

	}
	public List<String> getMakes(String model){
		List<String> makes = new ArrayList<String>();
		if(entriesMakes.size()==0){
			parseDatabaseMakes();
		}
		for (String[] entry : entriesMakes) {
			makes.add(entry[0]);
		}
		return makes;


	}
	public List<String> getYears(String model, String make, String year){
		List<String> years = new ArrayList<String>();
		if(entriesYears!=null){
			parseDatabaseYears();
		}
		for (String[] entry : entriesYears) {
			years.add(entry[1]);
		}
		return years;


	}

}
