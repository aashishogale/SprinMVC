package com.bridgelabz.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.dao.StudentDao;
import com.bridgelabz.model.Student;

public class StudentServiceImpl  implements StudentService {
	@Autowired
	StudentDao studentdao;

	public void register(Student student) {

		studentdao.register(student);
	}

	public boolean validateUser(Student student) {
		// TODO Auto-generated method stub
		return studentdao.validateUser(student);
	}

}
