package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.model.Student;

public class StudentDaoImpl implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void register(Student student) {
	

		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		session.save(student);
		System.out.println("Inserted Successfully");
		session.getTransaction().commit();
		session.close();

	}
	

	


	@Override
	public boolean validateUser(Student student) {
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		Query<Student> query = session.createQuery("from Student");
		List<Student> users = query.getResultList();

		for (Student students : users) {
		if(student.getEmail().equals(students.getEmail())&&student.getPassword().equals(students.getPassword())){
			return true;
		}
		
		
		}
		
		session.getTransaction().commit();
		session.close();
		return false;
		// TODO Auto-generated method stub
		
	}

}
