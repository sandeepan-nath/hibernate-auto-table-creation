package com.luv2code.hibernate.demo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Employee;
import com.luv2code.hibernate.model.EmployeeModel;

public class HibernateCutomGenDemo {

	public static void main(String[] args) {
		
		try {
			
			EmployeeModel employeeModel = new EmployeeModel();

			System.out.println("Add New Employee");
			Employee newEmployee = new Employee();
			newEmployee.setId("1");
			newEmployee.setName("Employee 3");
			newEmployee.setGender("male");
			System.out.println(employeeModel.create(newEmployee));
			
			System.out.println("List All Employee");
			for(Employee employee : employeeModel.findAll()) {
				System.out.println("Id: " + employee.getId());
				System.out.println("Name: " + employee.getName());
				System.out.println("Gender: " + employee.getGender());
				System.out.println("==================");
			}
			/*
			System.out.println("Find Employee By Id");
			Employee employeeInfo = employeeModel.findById("2017-10-23-10-32-42");
			System.out.println("Id: " + employeeInfo.getId());
			System.out.println("Name: " + employeeInfo.getName());
			System.out.println("Gender: " + employeeInfo.getGender());*/
			
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
