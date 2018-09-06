package com.metacube.training;

//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.FileSystemResource;

/**
 * Main class where dependency is injected using setter injection
 */
public class MainApp {
	public static void main(String[] args){
		//TextEditor textEditorObject = new SpellChecker();
		
		//BeanFactory factory = new XmlBeanFactory (new FileSystemResource("spring.xml"));
		//TextEditor textEditorObject = (TextEditor) factory.getBean("spellchecker");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		TextEditor textEditorObject = (TextEditor) context.getBean("textEditor");
		
		textEditorObject.display();
	}
}