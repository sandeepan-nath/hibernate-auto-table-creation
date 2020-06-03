package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class HibernateCutomGenDemo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Hib version ");
			System.out.println(org.hibernate.Version.getVersionString());
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.buildSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Add New Employee");
			Instructor newEmployee = new Instructor("Sandeepan","Nath","email");
			newEmployee.setInstructorDetail(new InstructorDetail("link","hobby"));
			
			session.save(newEmployee);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//sessionFactory.close();
			
		}
	}
	/*
	 * private static void printStudents(List<Student> students) { for(Student s:
	 * students) { System.out.println("see "+s); } }
	 */

}
