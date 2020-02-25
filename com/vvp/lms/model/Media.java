package com.vvp.lms.model;

public class Media 
{
	public String name,isbn,author;
	public int price,id,avail;
	public int user[]={-1,-1,-1,-1,-1}; //initialize array of user when any user not issued any book initial(store userid for issued book)
	public int user_index=0; 
	public Media(String isbn,String author,String name,int id,int price,int avail
		)
	{
		this.name=name;
		this.isbn=isbn;
		this.author=author;
		this.id=id;
		this.avail=avail;
		this.price=price;
	}
}