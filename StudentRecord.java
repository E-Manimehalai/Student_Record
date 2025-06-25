package Tasks;

import java.util.ArrayList;
import java.util.Scanner;
class Student
{
	private int id;
	private String name;
	private double mark;
	
	public Student(int id, String name, double mark)
	{
		this.id=id;
		this.name=name;
		this.mark=mark;
	}

	public int getId() 
	{
		return id;
	}

	public String getName() 
	{
		return name;
	}
	
	public double getMark() 
	{
		return mark;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public void setMark(double mark) 
	{
		this.mark = mark;
	}
	public void display()
	{
		System.out.println("Id: "+id);
		System.out.println("Name: "+name);
		System.out.println("Mark: "+mark);
	}
	
}

public class StudentRecord 
{
	static ArrayList<Student> list=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String args[])
	{
		int ch;
		while(true)
		{
			System.out.println("1.Add student");
			System.out.println("2.View student");
			System.out.println("3.Update student");
			System.out.println("4.Delete student");
			System.out.println("5.Exit");
			System.out.println("Enter your choice:");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1: add_student();
					break;
			case 2: view_student();
					break;
			case 3: update_student();
					break;
			case 4: delete_student();
					break;
			case 5: sc.close();
					System.exit(0);
			default: System.out.println("Invalid choice!!!");
			}
		}
	}

	private static void add_student() 
	{
		System.out.println("Enter Studend Id:");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Student Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Student Mark: ");
		double mark=sc.nextDouble();
		Student s=new Student(id,name,mark);
		list.add(s);
		System.out.println("Student details Added..\n");
		
	}
	private static void view_student()
	{
		if(list.isEmpty())
		{
			System.out.println("No record Found!!!\n");
		}
		for(Student s:list)
		{
			s.display();
		}
	}
	private static void update_student() 
	{
		System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : list) {
            if (s.getId() == id) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new marks: ");
                double newMarks = sc.nextDouble();
                s.setName(newName);
                s.setMark(newMarks);
                System.out.println("Student record updated.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
	}
	private static void delete_student()
	{
		System.out.println("Enter Student Id to delete:");
		int id=sc.nextInt();
		boolean del=list.removeIf(s->s.getId()==id);
		if(del) 
		{
	        System.out.println("Student deleted.");
	    } 
		else 
		{
	        System.out.println("Student not found.");
	    }
		
	}
}
