package com.vvp.lms.model;

public class DAO
{
	public static Student students[] = new Student[4];
	public static Staff staffs[]=new Staff[3];
	public static HardMedia hardMedias[]=new HardMedia[3];
	public static SoftMedia softMedias[]=new SoftMedia[3];
	public static void initData()
	{
		//public Student(String name,String branch,int id,int balance,int rollno)
		students[0]=new Student("Harsh","CE",0,0,59);
		students[1]=new Student("Mihir","CE",1,0,1);
		students[2]=new Student("Srujan","CE",2,0,60);
		students[3]=new Student("Ravi","CE",3,0,30);

		//public Staff(String name,String branch,int id,int balance,int salary,int experience)
		/*staffs[0]=new Staff("ABC","CE",1,101,20000,2);
		staffs[1]=new Staff("DEF","CE",2,102,30000,3);
		staffs[2]=new Staff("HIJ","CE",3,103,50000,4);*/

		//public HardMedia(String isbn,String author,String name,int id,int price,int avail,int pages,int weigth)
		hardMedias[0]=new HardMedia("1111","aaaa","C",0,500,5,300,400);
		hardMedias[1]=new HardMedia("1112","aaab","C++",1,600,5,400,500);
		hardMedias[2]=new HardMedia("1113","aaac","Java",2,700,5,600,550);
 
		//public SoftMedia(String isbn,String author,String name,int id,int price,int avail,String format,String size)
		/*softMedias[0]=new SoftMedia("2221","bbba","PHP",101,0,5,"PDF","10MB");
		softMedias[1]=new SoftMedia("2222","bbbb","JavaScript",102,0,5,"PDF","20MB");
		softMedias[2]=new SoftMedia("2223","bbbc","DBMS",103,0,5,"PDF","30MB");*/
	}
}