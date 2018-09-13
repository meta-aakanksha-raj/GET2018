package com.metacube.training;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Movie movie() {

		Movie movie = new Movie();
		List<String> listOfMovies = new ArrayList<String>();
		listOfMovies.add("Thor");
		listOfMovies.add("Avengers");
		listOfMovies.add("Men In Black");
		listOfMovies.add("Harry Potter");

		movie.setListOfMovies(listOfMovies);

		return movie;
	}
}
