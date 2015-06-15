package org.whitebread.foursquare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.whitebread.foursquare.model.Place;
import org.whitebread.foursquare.service.PlaceSearchService;

@Controller
@RequestMapping (value="/search" , method = RequestMethod.GET)
public class PlaceSearchController {

	private PlaceSearchService searchService;
	 
	public String searchPlace (@RequestParam("place") String place) {
		final List <Place> searchedPlaces =  searchService.findPlacesByName(place);
		//Model model = new Model();
		return null;
	}
}
