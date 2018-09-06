package com.metacube.training;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Movie movieObject = (Movie) context.getBean("movie");
		Set<String> setOfMovies = movieObject.getSetOfMovies();

		System.out.println("Set of movies :-");
		for (String movie : setOfMovies) {
			System.out.println(movie);
		}
	}
}
