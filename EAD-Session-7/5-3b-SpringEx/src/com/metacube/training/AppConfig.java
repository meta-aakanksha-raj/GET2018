package com.metacube.training;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Movie movie() {

		Movie movie = new Movie();
		Set<String> setOfMovies = new HashSet<String>();
		setOfMovies.add("Thor");
		setOfMovies.add("Avengers");
		setOfMovies.add("Men In Black");
		setOfMovies.add("Harry Potter");

		movie.setSetOfMovies(setOfMovies);

		return movie;
	}
}
