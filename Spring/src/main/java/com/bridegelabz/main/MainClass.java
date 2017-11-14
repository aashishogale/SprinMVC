package com.bridegelabz.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.model.Manager;

public class MainClass {
	public static void main(String arg[]){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");
        Manager manager=(Manager)applicationContext.getBean("Manager");	
	    manager.print();
	}
	

}
