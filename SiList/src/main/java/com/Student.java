package com;

import java.util.Iterator;
import java.util.List;

public class Student {
	private int rollno;
	private String name;
	private List<String> subjects;
	private List<Subjects> ssubjects;
	Student(){
		
	}
public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public List<Subjects> getSsubjects() {
		return ssubjects;
	}
	public void setSsubjects(List<Subjects> ssubjects) {
		this.ssubjects = ssubjects;
	}
public void show() {
    System.out.println(rollno+" "+name);  
     
    Iterator<String> itr=subjects.iterator();  
    Iterator<Subjects> itr2=ssubjects.iterator();
    while(itr.hasNext()){  
        System.out.println(itr.next());  
    }
    while(itr2.hasNext()){  
        System.out.println(itr2.next());  
    }
}
}
