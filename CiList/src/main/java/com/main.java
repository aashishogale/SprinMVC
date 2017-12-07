package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class main {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");
        Student student=(Student)applicationContext.getBean("student");	
	    student.show();
		// TODO Auto-generated method stub

	}

}
