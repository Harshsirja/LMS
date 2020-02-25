package com.vvp.lms.model;
public class Student extends User
{
	public int rollno;
	public Student(String name,String branch,int id,int balance,int rollno)
	{
		super(name,branch,id,balance);
		//this.enrollment=enrollment;
		this.rollno=rollno;
		//this.spi=spi;
	}
}