package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;
import com.bridgelabz.model.UserDao;
@Repository
public class UserDaoImpl implements UserDao {
	private static final SessionFactory sessionFactory;
	
	 static
	 {
	  try
	  {
	   sessionFactory = new Configuration().configure().buildSessionFactory();
	  }
	  catch(Throwable th){
	   System.err.println("Enitial SessionFactory creation failed"+th);
	   throw new ExceptionInInitializerError(th);
	  }
	   }
	   public SessionFactory getSessionFactory(){
	    return sessionFactory;
	   }

	public void addUser(User user) {
		Session session=this.getSessionFactory().getCurrentSession();
		session.persist(user);
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		Session session=this.getSessionFactory().getCurrentSession();
		session.update(user);
		
		// TODO Auto-generated method stub
		
	}
	

	public List<User> displayList() {
		Session session=this.getSessionFactory().getCurrentSession();
		List<User> list=session.createQuery("From User").list();
		return list;
	}

	public void deleteuser(int id) {
		Session session=this.getSessionFactory().getCurrentSession();
User user=(User)session.load(User.class, id);
session.remove(user);
		// TODO Auto-generated method stub
		
	}
	

}
