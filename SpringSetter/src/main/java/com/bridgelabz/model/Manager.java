package com.bridgelabz.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Manager {

private Employee employee;
public void setEmployee(Employee employee){
	this.employee=employee;
}

public void print(){
	System.out.print(employee.getName());
}
}
