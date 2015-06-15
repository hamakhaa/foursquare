package org.whitebread.foursquare.service;

import java.util.List;

import org.whitebread.foursquare.model.Place;

public interface PlaceSearchService {

	public List<Place> findPlacesByName();

}
