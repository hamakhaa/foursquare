package org.whitbread.foursquare.service;

import java.util.List;

import org.whitbread.foursquare.model.Place;

/**
 * Class that search for places using foursquare API
 * @author hamakhaa
 *
 */
public interface PlaceSearchService {

	public List<Place> findPlacesByName(String name);

}
