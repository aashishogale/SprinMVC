package com.bridgelabz.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.model.Student;

@Service
public interface StudentService {
	void register(Student student);
	boolean validateUser(Student student);

}
