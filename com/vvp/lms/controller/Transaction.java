package com.vvp.lms.controller;

import java.util.*;
import com.vvp.lms.model.*;


public class Transaction
{
	//static int book_index=0,user_index=0;
	public static int issueBook(int bookId,int userid)
	{
		int i,j,f1=0,f2=0;
		for (i=0;i<DAO.hardMedias.length ;i++ ) 
		{
			if(DAO.hardMedias[i].id==bookId)
			{
				//Book found
				f1=1;
				break;
			}
		}
		for (j=0;j<DAO.students.length ; j++)
		{
			if(DAO.students[j].id==userid)	
			{
				//student found
				f2=1;
				break;
			}
		}
		if (f1==0 && f2==0) 
		{
			//User and Book not found
			return -3;
		}
		else if (f1==0) 
		{
			//Book not found
			return -2;	
		}
		else if (f2==0) 
		{
			//User not found
			return -1;	
		}
		else if (f1==1 && f2==1 ) 
		{
			//Book and User Found
			if(DAO.students[j].balance < 5 && DAO.students[j].balance >= 0 )
			{
				//Balance limit not reached(Book issue allowed)
				DAO.students[j].balance++;
				DAO.hardMedias[i].avail--;
				DAO.students[j].book[bookId]=bookId;
				DAO.hardMedias[i].user[userid]=userid;
				return 1;
			}
			else
			{
				//Balance limit reached(Book issue not allowed)
				return -4;
			}	
		}	
		return -3;	
	}
	
	public static int returnBook(int bookId,int userid)
	{
		int i,j,f1=0,f2=0;
		for (j=0;j<DAO.students.length ; j++)
		{
			if(DAO.students[j].id==userid)	
			{
				//student found
				f2=1;
				break;
			}
		}
		for (i=0;i<DAO.hardMedias.length ;i++ ) 
		{
			if(DAO.hardMedias[i].id==bookId)
			{
				//Book found
				f1=1;
				break;
			}
		}
		if (f1==0 && f2==0) 
		{
			//Book and User not found
			return -3;
		}
		else if (f1==0) 
		{
			//Book not found
			return -2;	
		}
		else if (f2==0) 
		{
			//User not found
			return -1;	
		}
		else if (f1==1 && f2==1 ) 
		{
			//Book and User found
			if(DAO.students[j].balance < 5 && DAO.students[j].balance > 0 )
			{
				//returnbook done(0 < Balance > 5 )
				DAO.students[j].balance--;
				DAO.hardMedias[i].avail++;
				DAO.students[j].book[bookId]=-1;
				DAO.hardMedias[i].user[userid]=-1;
				return 1;
			}
			else
			{
				//balance not limit(Exception)
				return -4;
			}	
		}	
		return -3;
	}

	public static int checkBalance(int userid)
	{
		int j;
		int bal;
		for (j=0 ; j<DAO.students.length ; j++)
		{
			if(DAO.students[j].id==userid)	
			{
				//student found
				return DAO.students[j].balance;
			}
		}
		//student not found
		return -1;
	}

	public static int searchBook(int bookId)
	{
		int i;
		for (i=0;i<DAO.hardMedias.length ;i++ ) 
		{
			if(DAO.hardMedias[i].id==bookId && DAO.hardMedias[i].avail > 0)
			{
				return (DAO.hardMedias[i].avail);
				//Book found
			}
		}
		//Book not found
		return -1;
	}

	public static void bookDetails()
	{
		System.out.print("UserId\t\tUser\t\tBook\t\tBranch\t\tBalance\t\tRollNo\n");
		System.out.print("--------------------------------------------------------------------------------------\n");
		//loop for each student 
		for (int j=0;j<DAO.students.length ;j++ ) 
		{
			//loop for each book for each student(book array in each students object which contain issued bookid for particular student)
			for(int i=0;i<DAO.students[j].book.length;i++)
			{
				//if value at current bookid position for current student is between 0 to 2
				if(DAO.students[j].book[i] > -1 && DAO.students[j].book[i] < 3)
				{
					//System.out.print("UserId\t\tUser\t\tBook\t\tBranch\t\tBalance\t\tRollNo\n");
					System.out.println(DAO.students[j].id + "\t\t" + DAO.students[j].name + "\t\t" + DAO.hardMedias[ DAO.students[j].book[i] ].name + "\t\t" + DAO.students[j].branch + "\t\t" + DAO.students[j].balance + "\t\t" + DAO.students[j].rollno);
				}	
			}
		}
	}

	public static void userDetails()
	{
		System.out.print("BookId\t\tBook\t\tUser\t\tISBN\t\tAuthor\t\tPrice\t\tAvail\t\tPages\t\tWeigth\n");
		System.out.print("--------------------------------------------------------------------------------------------------------------------------------------\n");
		//loop for each book
		for (int i=0;i<DAO.hardMedias.length ;i++ ) 
		{
			//loop for each book for each student(user array in each hardMedias object which contain userid of stdudent for particular issed book)
			for (int j = 0; j < DAO.hardMedias[i].user.length ; j++ ) 
			{
				//if value at current userid position for current book is between 0 to 3
				if(DAO.hardMedias[i].user[j] >-1 && DAO.hardMedias[i].user[j] < 4)			
				{
					//System.out.print("BookId\t\tBook\t\tUser\t\tISBN\t\tAuthor\t\tPrice\t\tAvailable\t\tPages\t\tWeigth\n");
					System.out.println(DAO.hardMedias[i].id + "\t\t" + DAO.hardMedias[i].name + "\t\t" + DAO.students[ DAO.hardMedias[i].user[j] ].name + "\t\t" + DAO.hardMedias[i].isbn + "\t\t" + DAO.hardMedias[i].author + "\t\t" + DAO.hardMedias[i].price + "\t\t" + DAO.hardMedias[i].avail + "\t\t\t" + DAO.hardMedias[i].pages + "\t\t" + DAO.hardMedias[i].weigth );
				}
			}	
		}
	}
}