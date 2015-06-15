package org.whitbread.foursquare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.whitbread.foursquare.model.Place;
import org.whitbread.foursquare.service.PlaceSearchService;


/**
 * Controller that looks for places near 
 * to the place provided for search
 * @author hamakhaa
 *
 */
@Controller
public class PlaceSearchController {

	/**
	 * searchService to get the data from four square 
	 */
	private PlaceSearchService searchService;

	@RequestMapping (value="/search" , method = RequestMethod.POST)
	public String searchPlaces (@RequestParam("place") String place,Model model) {
		final List <Place> searchedPlaces =  searchService.findPlacesByName(place);
		model.addAttribute("searchedPlaces", searchedPlaces);
		model.addAttribute("place", place);
		return "";
	}

	public void setSearchService(final PlaceSearchService searchService) {
		this.searchService = searchService;
	}


}