package org.whitbread.foursquare.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.whitbread.foursquare.model.Place;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Service
public class PlaceSearchServiceImpl implements PlaceSearchService {

	/**
	 * Client Id for connecting to foursquare
	 */
	private String CLIENT_ID = "2YOLMASACQYB1NQK2H22KS2VEYVF50WT2FMXPNA3B31UBVXF";
	
	/**
	 * Client Secret for connecting to foursquare
	 */
	private String CLIENT_SECRET = "CQPPNDNS4XHEGTXPUM0IPTRNDQHGK3UGBFJFEBTP4AN2SNLN";
	
	public List<Place> findPlacesByName(final String name) {
		try {
			final Client client = Client.create();
			final WebResource webResource2 = client.resource("https://api.foursquare.com/v2/venues/search?client_id="+CLIENT_ID+
					"&client_secret="+CLIENT_SECRET+"&v=20130815&near="+name);
			
			final ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
			
			if (response2.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
			}
 
			final String output2 = response2.getEntity(String.class);
			return convertToJava(output2);

		} catch (final Exception e) {
			//TODO logging
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Converts the json object into java equivalent
	 * @param jsonString
	 * @return
	 */
	private List <Place> convertToJava(final String jsonString) {
		final List <Place> places = new ArrayList<Place>();

		try {
			
			//Create json related objects
			final ObjectMapper objectMapper = new ObjectMapper();
			final JsonNode rootNode = objectMapper.readTree(jsonString);
			final JsonNode venuesNode = rootNode.findPath("venues");
			final Iterator <JsonNode> venues = venuesNode.getElements();
			
			// Iterate each venue
			while(venues.hasNext()){
				final JsonNode venue = venues.next();
				final JsonNode name = venue.findPath("name");
				final JsonNode location = venue.findPath("location");

			    final Place place = new Place();
			    place.setLatitude(location.findPath("lat").asText());
			    place.setLongitude(location.findPath("lng").asText());
			    place.setName(name.asText());
			    places.add(place);
			}
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			//TODO logging
		} catch (IOException e) {
			e.printStackTrace();
			//TODO logging
		}
		return places;
	}
}
