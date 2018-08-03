package com.diksha;

public class Customer {
	
	private String title;
	private String firstname;
	private String lastname;
	private String Age;
	private String DOB;
	private int id=0;
	public Customer(String title, String firstname, String lastname, String age, String dOB) {
		super();
		id=id+1;
		this.title = title;
		this.firstname = firstname;
		this.lastname = lastname;
		Age = age;
		DOB = dOB;
	}
	
	
	public Customer() {
		super();
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Customer [title=" + title + ", firstname=" + firstname + ", lastname=" + lastname + ", Age=" + Age
				+ ", DOB=" + DOB + ", id=" + id + "]";
	}
	
	
	

}
