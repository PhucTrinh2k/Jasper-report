package com.infybuzz.report;

public class Student {
	
	private double id;
	private String firstName;
	private String lastName;
	private long another_id;
	private String city;
	
	public Student(double id, String firstName, String lastName, long another_id, String city) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.another_id = another_id;
		this.city = city;
	}
	public double getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public long getAnother_id() {
		return another_id;
	}
	public String getCity() {
		return city;
	}
	public void setId(double id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAnother_id(long another_id) {
		this.another_id = another_id;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
}
