package com.metacube.training;

import java.util.Map;

public class Movie {
	private Map<String, Double> ratingsOfMovies;

	/**
	 * @return the listOfMovies
	 */
	public Map<String, Double> getRatingsOfMovies() {
		return ratingsOfMovies;
	}

	/**
	 * @param listOfMovies the listOfMovies to set
	 */
	public void setRatingsOfMovies(Map<String, Double> ratingsOfMovies) {
		this.ratingsOfMovies = ratingsOfMovies;
	}
}
