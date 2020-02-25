package com.vvp.lms.view;
import java.util.Scanner;
import com.vvp.lms.model.*;
import com.vvp.lms.controller.*;

class LibView
{
	public static void main(String args[]) 
	{
		DAO data=new DAO();
		data.initData();
		Scanner keyboard=new Scanner(System.in);
		while(true)
		{
			int c,m,r,bookid,userid;
			System.out.println("1. IssueBook");
			System.out.println("2. ReturnBook");
			System.out.println("3. CheckBalance");
			System.out.println("4. SearchBook");
			System.out.println("5. User Detail");
			System.out.println("6. Media Detail");
			System.out.println("7+.Exit");
			c = keyboard.nextInt();
			switch(c)
			{
				case 1: System.out.println("Enter BookId");
						bookid=keyboard.nextInt();
						System.out.println("Enter UserId");
						userid=keyboard.nextInt();
						r=Transaction.issueBook(bookid,userid);

						if (r==1) 
							System.out.println("Book issued..");
							//System.out.println(DAO.students[2].balance);
						else if(r==-1)
							System.out.println("User not found");
						else if(r==-2)	
							System.out.println("Book not found");
						else if(r==-3)
							System.out.println("Book & User not found");
						else if(r==-4)
							System.out.println("Maximum Book issue limit reach");
						else
							System.out.println("Error");
						break;

				case 2:	System.out.println("Enter BookId");
						bookid=keyboard.nextInt();
						System.out.println("Enter UserId");
						userid=keyboard.nextInt();
						r=Transaction.returnBook(bookid,userid);

						if (r==1) 
							System.out.println("Book returned..");
						else if(r==-1)
							System.out.println("User not found");
						else if(r==-2)	
							System.out.println("Book not found");
						else if(r==-3)
							System.out.println("Book & User not found");
						else if(r==-4)
							System.out.println("Book not returned please issue book first \nDear user " + userid + " (userid) is null");
						else
							System.out.println("Error");
						break;

				case 3:	System.out.println("Enter UserId");
						userid=keyboard.nextInt();
						r=Transaction.checkBalance(userid);

						if(r==-1)
						{
							System.out.println("User not found");
						}
						else
						{
							System.out.println("Your Balance is " + r + ".");	
						}
						break;

				case 4:	System.out.println("Enter BookId");
						bookid=keyboard.nextInt();
						r=Transaction.searchBook(bookid);
						if(r==-1)
						{
							System.out.println("Book not found");	
						}
						else
						{
							System.out.println(r + " Book Available of " +  DAO.hardMedias[bookid].name);
						}
						break;

				case 5: Transaction.bookDetails();
						break;

				case 6: Transaction.userDetails();
						break;
				case 7:System.exit(0);
						break;
				default:System.exit(0);
						break;
			}
		}
	}
}
