package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class for autowiring by type
 */
public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		TextEditor textEditorObject = (TextEditor) context .getBean("textEditor");
		textEditorObject.display();
	}
}
