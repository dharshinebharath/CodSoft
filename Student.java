package dharshine;
import java.util.*;

public class Student {
	
	public static String name;
	public static int id;
	int num;
	static double avgper;
	static char grade;
	static int total=0;
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Student()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter student name:");
		this.setName(in.next().toUpperCase());
		System.out.println("Enter student id:");
		this.setId(in.nextInt());
		
	}
	public void totalmark() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of subjects:");
		num=sc.nextInt();
		
		for(int i=1;i<=num;i++)
		{
			
			System.out.println("Enter the mark"+i+" :");
			int marks=sc.nextInt();
			while(marks>100 || marks<1)
			{
				System.out.println("Invalid mark!!.Please enter the valid mark.");
				marks=sc.nextInt();
				
			}
			total+=marks;
		}
		avgper=total/num;
	}
	
	public void findgrade()
	{
		if(avgper>=91)
			grade='O';
		
		else if (avgper>=81 && avgper<91)
			grade='A';
		
		else if (avgper>=71 && avgper<81)
			grade='B';
		
		else if (avgper>=61 && avgper<71)
			grade='C';
		
		else if (avgper>=50 && avgper<61)
			grade='D';
		
		else
			grade='F';
	}
	
	public static void main(String args[])
	{
		System.out.println("STUDENT GRADE CALCULATOR : ");
		Student stud=new Student();
		stud.totalmark();
		stud.findgrade();
		System.out.println("STUDENT NAME : "+name);
		System.out.println("STUDENT ID : "+id);
		System.out.println("TOTAL MARKS : "+total);
		System.out.println("AVERAGE PERCENTAGE : "+avgper+"%");
		System.out.println("GRADE : " + grade);
		
	}
}