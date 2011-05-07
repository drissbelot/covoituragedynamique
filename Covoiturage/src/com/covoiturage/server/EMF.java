/*
 * 
 */
package com.covoiturage.server;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// TODO: Auto-generated Javadoc
/**
 * The Class EMF.
 */
public final class EMF {

	/** The Constant emfInstance. */
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	/**
	 * Gets the.
	 *
	 * @return the entity manager factory
	 */
	public static EntityManagerFactory get() {
		return emfInstance;
	}

	/**
	 * Instantiates a new eMF.
	 */
	private EMF() {

	}

}
