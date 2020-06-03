package com.luv2code.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Instructor {
	
	@Id
	//@GenericGenerator(name="my_custom",strategy = "com.luv2code.hibernate.demo.MySequenceGenerator")
	//@GeneratedValue(generator="my_custom")
		@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id")
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	

	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	
	@OneToOne(targetEntity=InstructorDetail.class, cascade={CascadeType.ALL})
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}


	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}


	public Instructor() {
		
	}
	
	public Instructor(Integer id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	

}
