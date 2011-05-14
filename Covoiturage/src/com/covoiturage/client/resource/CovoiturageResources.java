/*
 * 
 */
package com.covoiturage.client.resource;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

// TODO: Auto-generated Javadoc
/**
 * The Interface CovoiturageResources.
 */
public interface CovoiturageResources extends ClientBundle {

	/**
	 * Taxi.
	 * 
	 * @return the image resource
	 */
	ImageResource taxi();

	/**
	 * Invalid.
	 * 
	 * @return the image resource
	 */
	ImageResource invalid();

	/**
	 * Valid.
	 * 
	 * @return the image resource
	 */
	ImageResource valid();

	@ImageOptions(repeatStyle = RepeatStyle.None)
	ImageResource shade();

	@Source("border.png")
	@ImageOptions(repeatStyle = RepeatStyle.None)
	ImageResource border();

	@NotStrict
	@Source("stylesheet.css")
	CovoiturageCssResources style();

	@ImageOptions(repeatStyle = RepeatStyle.None)
	ImageResource covdyn();

}
