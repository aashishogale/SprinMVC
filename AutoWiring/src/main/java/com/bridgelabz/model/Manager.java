package com.bridgelabz.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author aashish
 *
 */
public class Manager {
	@Autowired
	private Employee employee;

	public void setEmployee(Employee employee) {
		this.employee = employee;
		this.employee.setName("ashish");
	}

	
	public void print() {
		System.out.print(employee.getName());
	}
}
