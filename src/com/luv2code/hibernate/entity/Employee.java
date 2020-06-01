package com.luv2code.hibernate.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee")
public class Employee implements java.io.Serializable {

	
	@GenericGenerator(name = "ran", strategy = "com.luv2code.hibernate.demo.MySequenceGenerator")
	@GeneratedValue(generator = "ran")
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column
	private String name;

	@Column
	private String gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
