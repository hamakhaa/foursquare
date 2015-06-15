package org.whitbread.foursquare.model;

/**
 * Pojo to hold the venue/place data 
 * that we fetch from foursquare api
 * @author hamakhaa
 *
 */
public class Place {
	
	/**
	 * Name of the place
	 */
	private String name;
	
	/**
	 * Longitude coordinate
	 */
	private String longitude;
	
	/**
	 * Latitude coordinate
	 */
	private String latitude;

	/**
	 * Returns the name
	 * @return String 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the longitude coordinate for the venue
	 * @return String
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * Returns the latitude coordinate for the venue
	 * @return String 
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Sets the venue
	 * @return String
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Sets the lonitude
	 * @param longitude
	 */
	public void setLongitude(final String longitude) {
		this.longitude = longitude;
	}

	/**
	 * Returns the longitude coordinate for the venue
	 * @return String
	 */
	public void setLatitude(final String latitude) {
		this.latitude = latitude;
	}
	
	
}
