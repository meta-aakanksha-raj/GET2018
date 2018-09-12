package com.metacube.training;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Movie movie() {

		Movie movie = new Movie();
		Map<String, Double> ratingsOfMovies = new HashMap<String, Double>();
		ratingsOfMovies.put("Thor", 5.0);
		ratingsOfMovies.put("Avengers", 4.9);
		ratingsOfMovies.put("Men In Black", 4.9);
		ratingsOfMovies.put("Harry Potter", 5.0);

		movie.setRatingsOfMovies(ratingsOfMovies);

		return movie;
	}
}
