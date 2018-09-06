package com.metacube.training;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class for Injecting list Collection
 */
public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Movie movieObject = (Movie) context.getBean("movie");
		List<String> listOfMovies = movieObject.getListOfMovies();

		System.out.println("List of movies :-");
		for (String movie : listOfMovies) {
			System.out.println(movie);
		}
	}
}
