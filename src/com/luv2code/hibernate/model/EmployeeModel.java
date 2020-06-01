package com.luv2code.hibernate.model;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.entity.Employee;

public class EmployeeModel {

	private SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
			.buildSessionFactory();

	public Boolean create(Employee employee) {
		System.out.println("Called create");
		Boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {

			System.out.println("Step 1");
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			System.out.println("Commit done");
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public List<Employee> findAll() {
		List<Employee> employees = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("from Employee");
			employees = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			employees = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return employees;
	}

	public Employee findById(String id) {
		Employee employee = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("from Employee where id = :id");
			query.setParameter("id", id);
			employee = (Employee) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			employee = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return employee;
	}

}