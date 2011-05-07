/*
 * 
 */
package com.covoiturage.server.locator;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

// TODO: Auto-generated Javadoc
/**
 * Generic locator service that can be referenced in the @Service annotation for
 * any RequestFactory service stub.
 */
public class DaoServiceLocator implements ServiceLocator {

	/* (non-Javadoc)
	 * @see com.google.web.bindery.requestfactory.shared.ServiceLocator#getInstance(java.lang.Class)
	 */
	@Override
	public Object getInstance(Class<?> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
