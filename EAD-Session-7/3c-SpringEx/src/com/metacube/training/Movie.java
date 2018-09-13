package com.metacube.training;

import java.util.Map;

public class Movie {
	private Map<String, Float> ratingsOfMovies;

	/**
	 * @return the listOfMovies
	 */
	public Map<String, Float> getRatingsOfMovies() {
		return ratingsOfMovies;
	}

	/**
	 * @param listOfMovies the listOfMovies to set
	 */
	public void setRatingsOfMovies(Map<String, Float> ratingsOfMovies) {
		this.ratingsOfMovies = ratingsOfMovies;
	}
}
