package org.whitebread.foursquare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.whitebread.foursquare.service.PlaceSearchService;

@Controller
@RequestMapping (value="/search")
public class PlaceSearchController {

	private PlaceSearchService searchService;
	
	public String searchPlace (@RequestParam("place") int id) {
		return null;
	}
}
