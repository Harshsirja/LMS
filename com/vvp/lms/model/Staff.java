package com.vvp.lms.model;
public class Staff extends User
{
	public int salary,experience,id;
	public String post;
	public Staff(String name,String branch,int id,int balance,int salary,int experience)
	{
		super(name,branch,id,balance);
		this.salary=salary;
		this.experience=experience;
	}
}