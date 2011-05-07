/*
 * 
 */
package com.covoiturage.server.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Embedded;
import javax.persistence.Transient;

import com.covoiturage.server.TooManyResultsException;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.util.DAOBase;

// TODO: Auto-generated Javadoc
/**
 * Generic DAO for use with Objectify.
 *
 * @param <T> the generic type
 */
public class ObjectifyDao<T> extends DAOBase {

	/** The Constant BAD_MODIFIERS. */
	static final int BAD_MODIFIERS = Modifier.FINAL | Modifier.STATIC
			| Modifier.TRANSIENT;

	static {

	}

	/** The clazz. */
	protected Class<T> clazz;

	/**
	 * Instantiates a new objectify dao.
	 */
	@SuppressWarnings("unchecked")
	public ObjectifyDao() {
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Put.
	 *
	 * @param entity the entity
	 * @return the key
	 */
	public Key<T> put(T entity)

	{
		return ofy().put(entity);
	}

	/**
	 * Put all.
	 *
	 * @param entities the entities
	 * @return the map
	 */
	public Map<Key<T>, T> putAll(Iterable<T> entities) {
		return ofy().put(entities);
	}

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	public void delete(T entity) {
		ofy().delete(entity);
	}

	/**
	 * Delete key.
	 *
	 * @param entityKey the entity key
	 */
	public void deleteKey(Key<T> entityKey) {
		ofy().delete(entityKey);
	}

	/**
	 * Delete all.
	 *
	 * @param entities the entities
	 */
	public void deleteAll(Iterable<T> entities) {
		ofy().delete(entities);
	}

	/**
	 * Delete keys.
	 *
	 * @param keys the keys
	 */
	public void deleteKeys(Iterable<Key<T>> keys) {
		ofy().delete(keys);
	}

	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the t
	 * @throws EntityNotFoundException the entity not found exception
	 */
	public T get(Long id) throws EntityNotFoundException {
		return ofy().get(this.clazz, id);
	}

	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the t
	 * @throws EntityNotFoundException the entity not found exception
	 */
	public T get(Key<T> key) throws EntityNotFoundException {
		return ofy().get(key);
	}

	/**
	 * Gets the.
	 *
	 * @param keys the keys
	 * @return the map
	 */
	public Map<Key<T>, T> get(Iterable<Key<T>> keys) {
		return ofy().get(keys);
	}

	/**
	 * List all.
	 *
	 * @return the list
	 */
	public List<T> listAll() {
		Query<T> q = ofy().query(clazz);
		return q.list();
	}

	/**
	 * Convenience method to get all objects matching a single property.
	 *
	 * @param propName the prop name
	 * @param propValue the prop value
	 * @return T matching Object
	 * @throws TooManyResultsException the too many results exception
	 */
	public T getByProperty(String propName, Object propValue)
			throws TooManyResultsException {
		Query<T> q = ofy().query(clazz);
		q.filter(propName, propValue);
		Iterator<T> fetch = q.limit(2).list().iterator();
		if (!fetch.hasNext()) {
			return null;
		}
		T obj = fetch.next();
		if (fetch.hasNext()) {
			throw new TooManyResultsException(q.toString()
					+ " returned too many results");
		}
		return obj;
	}

	/**
	 * List by property.
	 *
	 * @param propName the prop name
	 * @param propValue the prop value
	 * @return the list
	 */
	public List<T> listByProperty(String propName, Object propValue) {
		Query<T> q = ofy().query(clazz);
		q.filter(propName, propValue);
		return q.list();
	}

	/**
	 * List keys by property.
	 *
	 * @param propName the prop name
	 * @param propValue the prop value
	 * @return the list
	 */
	public List<Key<T>> listKeysByProperty(String propName, Object propValue) {
		Query<T> q = ofy().query(clazz);
		q.filter(propName, propValue);
		return q.listKeys();
	}

	/**
	 * Gets the by example.
	 *
	 * @param exampleObj the example obj
	 * @return the by example
	 * @throws TooManyResultsException the too many results exception
	 */
	public T getByExample(T exampleObj) throws TooManyResultsException {
		Query<T> q = buildQueryByExample(exampleObj);
		Iterator<T> fetch = q.limit(2).list().iterator();
		if (!fetch.hasNext()) {
			return null;
		}
		T obj = fetch.next();
		if (fetch.hasNext()) {
			throw new TooManyResultsException(q.toString()
					+ " returned too many results");
		}
		return obj;
	}

	/**
	 * List by example.
	 *
	 * @param exampleObj the example obj
	 * @return the list
	 */
	public List<T> listByExample(T exampleObj) {
		Query<T> queryByExample = buildQueryByExample(exampleObj);
		return queryByExample.list();
	}

	/**
	 * Gets the key.
	 *
	 * @param id the id
	 * @return the key
	 */
	public Key<T> getKey(String id) {
		return new Key<T>(this.clazz, id);
	}

	/**
	 * Key.
	 *
	 * @param obj the obj
	 * @return the key
	 */
	public Key<T> key(T obj) {
		return ObjectifyService.factory().getKey(obj);
	}

	/**
	 * List children.
	 *
	 * @param parent the parent
	 * @return the list
	 */
	public List<T> listChildren(Object parent) {
		return ofy().query(clazz).ancestor(parent).list();
	}

	/**
	 * List child keys.
	 *
	 * @param parent the parent
	 * @return the list
	 */
	public List<Key<T>> listChildKeys(Object parent) {
		return ofy().query(clazz).ancestor(parent).listKeys();
	}

	/**
	 * Builds the query by example.
	 *
	 * @param exampleObj the example obj
	 * @return the query
	 */
	protected Query<T> buildQueryByExample(T exampleObj) {
		Query<T> q = ofy().query(clazz);

		// Add all non-null properties to query filter
		for (Field field : clazz.getDeclaredFields()) {
			// Ignore transient, embedded, array, and collection properties
			if (field.isAnnotationPresent(Transient.class)
					|| (field.isAnnotationPresent(Embedded.class))
					|| (field.getType().isArray())
					|| (field.getType().isArray())
					|| (Collection.class.isAssignableFrom(field.getType()))
					|| ((field.getModifiers() & BAD_MODIFIERS) != 0))
				continue;

			field.setAccessible(true);

			Object value;
			try {
				value = field.get(exampleObj);
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
			if (value != null) {
				q.filter(field.getName(), value);
			}
		}

		return q;
	}
}
