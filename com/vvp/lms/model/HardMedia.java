package com.vvp.lms.model;
public class HardMedia extends Media 
{
	public int pages,weigth;
	public HardMedia(String isbn,String author,String name,int id,int price,int avail,int pages,int weigth)
	{
		super(isbn,author,name,id,price,avail);
		this.pages=pages;
		this.weigth=weigth;	
	}
}