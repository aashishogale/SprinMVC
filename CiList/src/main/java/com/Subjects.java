package com;


/**
 * @author aashish
 *
 */
public class Subjects {
	private int marks;
	private String name;


	public Subjects(int marks, String name) {
		this.marks = marks;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Subjects [marks=" + marks + ", name=" + name + "]";
	}

}
