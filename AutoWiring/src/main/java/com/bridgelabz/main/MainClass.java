package com.bridgelabz.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.model.Employee;
import com.bridgelabz.model.Manager;

public class MainClass {
	public static void main(String arg[]){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");
        Manager manager=(Manager)applicationContext.getBean("Manager");	
      Employee employee=(Employee)applicationContext.getBean("Employee");	
        manager.setEmployee(employee);
	    manager.print();
	}
	

}
