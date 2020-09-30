package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Student;

public class GetInstrDetailDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int id = 3333; //primaty key in instr_details
			InstructorDetail instance = session
					.get(InstructorDetail.class, id);
			
			System.out.println(instance);
			
			System.out.println(instance.getInstructor());
			
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
			factory.close();
		}
	}

}
