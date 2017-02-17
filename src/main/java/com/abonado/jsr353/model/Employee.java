package com.abonado.jsr353.model;

import java.util.Date;

public class Employee {
	private String firstName;
	private String lastName;
	private String email;
	private int employeeId;
	private Date hireDate;
	
	public Employee(){
		
	}
	
	public Employee(String firstName, String lastName, String email, int employeeId, Date hireDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeId = employeeId;
		this.hireDate = hireDate;
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
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public String toString(){
		return "FirstName:"+firstName+" LastName:"+lastName+" EmployeeID:"+employeeId+" HireDate:"+hireDate+" Email:"+email;
	}

	
}
