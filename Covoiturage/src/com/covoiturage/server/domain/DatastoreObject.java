/*
 * 
 */
package com.covoiturage.server.domain;
import javax.persistence.Id;
import javax.persistence.PrePersist;

// TODO: Auto-generated Javadoc
/**
 * The Class DatastoreObject.
 */
public class DatastoreObject {


	/** The id. */
	@Id
	private Long id;
	
	/** The version. */
	private Integer version = 0;

	/**
	 * Auto-increment version # whenever persisted.
	 */
	@PrePersist
	void onPersist()
	{
		this.version++;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Integer getVersion()
	{
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(Integer version)
	{
		this.version = version;
	}


}
