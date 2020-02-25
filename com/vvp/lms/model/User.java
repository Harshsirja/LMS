package com.vvp.lms.model;

public class User
{
	public String name,branch;
	public int id,balance;
	public int book_index=0;
	public int book[]={-1,-1,-1}; //initialize array of book when no book issued initial for each students object(store issued bookid for each user)
	public User(String name,String branch,int id,int balance)
	{

		this.name=name;
		this.branch=branch;
		this.id=id;
		this.balance=balance;
	}
}