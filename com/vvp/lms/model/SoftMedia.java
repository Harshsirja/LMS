package com.vvp.lms.model;
public class SoftMedia extends Media
{
	public String format,size;
	public SoftMedia(String isbn,String author,String name,int id,int price,int avail,String format,String size)
	{
		super(isbn,author,name,id,price,avail);
		this.format=format;
		this.size=size;
	}
}