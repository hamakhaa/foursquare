package org.whitebread.foursquare.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.whitebread.foursquare.model.Place;

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
	private String CLIENT_SECRET = "2YOLMASACQYB1NQK2H22KS2VEYVF50WT2FMXPNA3B31UBVXF";
	
	public List<Place> findPlacesByName(final String name) {
		try {
			final Client client = Client.create();
			final WebResource webResource2 = client.resource("https://api.foursquare.com/v2/venues/search?client_id="+CLIENT_ID+
					"&client_secret"+CLIENT_SECRET+"&v=20130815&near"+name);
			
			final ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
			
			if (response2.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
			}
 
			final String output2 = response2.getEntity(String.class);
			System.out.println(output2);
 
		} catch (final Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
