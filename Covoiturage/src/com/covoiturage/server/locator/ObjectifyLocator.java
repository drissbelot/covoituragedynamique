/*
 * 
 */
package com.covoiturage.server.locator;

import com.covoiturage.server.domain.DatastoreObject;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.googlecode.objectify.util.DAOBase;

// TODO: Auto-generated Javadoc
/**
 * Generic @Locator for objects that extend DatastoreObject.
 */
public class ObjectifyLocator extends Locator<DatastoreObject, Long> {
	
	/* (non-Javadoc)
	 * @see com.google.web.bindery.requestfactory.shared.Locator#create(java.lang.Class)
	 */
	@Override
	public DatastoreObject create(Class<? extends DatastoreObject> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.google.web.bindery.requestfactory.shared.Locator#find(java.lang.Class, java.lang.Object)
	 */
	@Override
	public DatastoreObject find(Class<? extends DatastoreObject> clazz, Long id) {
		DAOBase daoBase = new DAOBase();
		return daoBase.ofy().find(clazz, id);
	}

	/* (non-Javadoc)
	 * @see com.google.web.bindery.requestfactory.shared.Locator#getDomainType()
	 */
	@Override
	public Class<DatastoreObject> getDomainType() {
		// Never called
		return null;
	}

	/* (non-Javadoc)
	 * @see com.google.web.bindery.requestfactory.shared.Locator#getId(java.lang.Object)
	 */
	@Override
	public Long getId(DatastoreObject domainObject) {
		return domainObject.getId();
	}

	/* (non-Javadoc)
	 * @see com.google.web.bindery.requestfactory.shared.Locator#getIdType()
	 */
	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	/* (non-Javadoc)
	 * @see com.google.web.bindery.requestfactory.shared.Locator#getVersion(java.lang.Object)
	 */
	@Override
	public Object getVersion(DatastoreObject domainObject) {
		return domainObject.getVersion();
	}
}
