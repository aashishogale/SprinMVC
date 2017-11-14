package com.bridgelabz.model;

public class Manager {
private Employee employee;
public void setEmployee(Employee employee){
	this.employee=employee;
}

public void print(){
	System.out.print(employee.getName());
}
}
