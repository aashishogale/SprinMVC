package com;

public class Subjects {
	private int marks;
	private String name;
	Subjects(int marks,String name){
		this.marks=marks;
		this.name=name;
	}
	public String toString(){  
	    return marks+" "+name;  
	}  

}
