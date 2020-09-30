package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor ins = new Instructor("A", "B", "email");
			
			InstructorDetail insDetail = new InstructorDetail("yt","hobby");
			
			ins.setInstructorDetail(insDetail);
			
			session.beginTransaction();
			
			//This will also save the detail object because of CascadeType.ALL
			session.save(ins);
			
			
			
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
		}
	}

}
