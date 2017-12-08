package com.bridgelabz.model;

/**
 * 
 * @author bridgelabz
 *
 */
public class Manager {
	private Employee employee;

	public Manager() {}//

	public Manager(Employee employee) {
		this.employee = employee;
	}

	/**
	 * 
	 */
	public void print() {
		System.out.print(employee.getName());
	}
}
