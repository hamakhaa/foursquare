package org.whitebread.foursquare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.whitebread.foursquare.model.Place;
import org.whitebread.foursquare.service.PlaceSearchService;

/**
 * Controller that looks for places near to the place provided for search
 * @author hamakhaa
 *
 */
@Controller
public class PlaceSearchController {

	private PlaceSearchService searchService;

	@RequestMapping (value="/search" , method = RequestMethod.POST)
	public String searchPlace (@RequestParam("place") String place,Model model) {
		final List <Place> searchedPlaces =  searchService.findPlacesByName(place);
		model.addAttribute("searchedPlaces", searchedPlaces);
		return null;
	}

//	@RequestMapping (value="/home" , method = RequestMethod.GET)
//	public String getPage () {
//		return "redirect:index.jsp";
//	}

}
