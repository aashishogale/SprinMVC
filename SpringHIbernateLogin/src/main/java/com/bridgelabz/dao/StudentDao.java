package com.bridgelabz.dao;


import com.bridgelabz.model.Student;


public interface StudentDao {
	void register(Student student);
	Student validateUser(Student student);
	

}
