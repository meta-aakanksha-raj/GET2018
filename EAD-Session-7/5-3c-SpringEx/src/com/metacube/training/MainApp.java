package com.metacube.training;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Movie movieObject = (Movie) context.getBean("movie");
		Map<String, Double> ratingsOfMovies = movieObject.getRatingsOfMovies();

		System.out.println("List of movies :-");
		System.out.println("Movie\t\tRating");
		for (String movie : ratingsOfMovies.keySet()) {
			System.out.println(movie + "\t\t" + ratingsOfMovies.get(movie));
		}
	}
}
