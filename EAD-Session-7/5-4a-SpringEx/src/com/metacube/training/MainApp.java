package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class for singleton bean scope using annotation
 */
public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Person personOne = (Person) context.getBean("person");
		System.out.println("Name of person One : " + personOne.getName());
		personOne.setName("Potter");
		System.out.println("Updated name of person One : "+ personOne.getName());

		Person personTwo = (Person) context.getBean("person");
		System.out.println("Name of person two : " + personTwo.getName());
	}
}
