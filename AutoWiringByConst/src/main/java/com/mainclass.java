package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainclass {

	public static void main(String[] args) {
		   ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		      TextEditor te = (TextEditor) context.getBean("textEditor");
		      te.spellCheck();
		   
		// TODO Auto-generated method stub

	}

}
