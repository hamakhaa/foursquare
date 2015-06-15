package org.whitbread.foursquare.service;

import java.util.List;

import org.whitbread.foursquare.model.Place;

/**
 * Class that search for places using foursquare API
 * @author hamakhaa
 *
 */
public interface PlaceSearchService {

	/**
	 * Finds nearest places to the place you 
	 * have passed in as search parameter
	 * @param name
	 * @return List of nearest places
	 */
	public List<Place> findPlacesByName(String name);

}
