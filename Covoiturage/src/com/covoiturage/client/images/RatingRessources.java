package com.covoiturage.client.images;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface RatingRessources extends ClientBundle {
	@Source("star.png")
	ImageResource star();

	@Source("fourstar.png")
	ImageResource fourStar();

	@Source("threestar.png")
	ImageResource threeStar();

	@Source("twostar.png")
	ImageResource twoStar();

}
