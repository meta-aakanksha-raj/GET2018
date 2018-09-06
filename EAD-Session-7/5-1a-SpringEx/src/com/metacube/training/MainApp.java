package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class where dependency is injected using setter injection using annotation
 */
public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		TextEditor textEditorObject = (TextEditor) context.getBean("textEditor");

		textEditorObject.display();
	}
}
