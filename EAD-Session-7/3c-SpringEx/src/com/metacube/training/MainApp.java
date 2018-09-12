package com.metacube.training;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class for Injecting map Collection
 */
public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Movie movieObject = (Movie) context.getBean("movie");
		Map<String, Float> ratingsOfMovies = movieObject.getRatingsOfMovies();

		System.out.println("List of movies :-");
		System.out.println("Movie\t\tRating");
		for (String movie : ratingsOfMovies.keySet()) {
			System.out.println(movie + "\t\t" + ratingsOfMovies.get(movie));
		}
	}
}
