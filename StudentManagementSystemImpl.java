package studentDatabaseManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customException.InvalidChoiceException;
import customException.StudentNotFountException;
import customSorting.SortStudentByAge;
import customSorting.SortStudentById;
import customSorting.SortStudentByMarks;
import customSorting.SortStudentByName;

// 2. implementation class  
public class StudentManagementSystemImpl implements StudentManagementSystem{

	Scanner scan = new Scanner(System.in);

	//	we are using Collection as ur database -> Map -> LinkedHashMap
	//	key -> Student Id and Value -> Student Object
	Map<String, Student> db = new LinkedHashMap<String, Student>();	

	@Override
	public void addStudents() 
	{
		//		Accepting Age
		System.out.println("Enter Age :");
		int age = scan.nextInt();

		//		accepting Name
		System.out.println("Enter Name :");
		String name = scan.next();

		//		Accepting Marks
		System.out.println("Enter Marks :");
		int marks = scan.nextInt();

		//		Creating an Instance (object) of student
		Student std = new Student(age, name, marks);

		//		adding student object into database -> Map
		db.put(std.getId(), std);

		System.out.println("Student record Added Successfully!!");
		System.out.println("Your Id is :"+std.getId());

	}

	@Override
	public void displayStudent() 
	{
		//		Accepting Student Id and converting into uppercase
		System.out.println("Enter Student Id :");
		String id = scan.next();	//JSP101 Jsp101 jsp101
		id = id.toUpperCase();  	//JSP101

		//		Checking if the id is present or not
		if(db.containsKey(id))
		{
			Student std = db.get(id);		//getting the value (Student Object) and storing it in std 

			System.out.println("ID :"+std.getId());
			System.out.println("Age :"+std.getAge());
			System.out.println("Name :"+std.getName());
			System.out.println("Marks :"+std.getMarks());

			//			System.out.println(std);  -> toString is Overridden
		}
		else
		{
			try
			{
				String message = "Student with id "+id+" is Not Found";
				throw new StudentNotFountException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void displayAllStudents() 
	{
		//		Displaying when the database is not empty
		if(!db.isEmpty())
		{
			System.out.println("Student Details are as follows :");
			System.out.println("--------------------------------");

			//		converting Map into Set using keySet()
			Set<String> keys = db.keySet();			//JSP101 JSP102 JSP103...

			//		Traversing keys (Student ID's)
			for(String key : keys)
			{
				System.out.println(db.get(key));	//getting value (student details)
			}
		}
		else
		{
			try 
			{
				String message = "No Student Records Found to Display";
				throw new StudentNotFountException(message);
			}
			catch(StudentNotFountException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void removeStudents() 
	{
		System.out.println("Enter student ID:");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student Record Found");
			db.remove(id);
			System.out.println("Student detail remove succesfully");
		}
		else {

			try {
				String message="No such id present";
				throw new StudentNotFountException(message);
			}
			catch(StudentNotFountException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void removeAllStudents() 
	{
		if(!db.isEmpty())
		{
			System.out.println("Number of Student Records :"+db.size());
			db.clear();
			System.out.println("All Student Records Deleted Successfully!");
		}
		else
		{
			try 
			{
				String message = "No Student Records Found to Delete";
				throw new StudentNotFountException(message);
			}
			catch(StudentNotFountException e)
			{
				System.out.println(e.getMessage());
			}	
		}
	}


	@Override
	public void updateStudents() 
	{
		System.out.println("Enter student id");
		String id=scan.next();
		id=id.toUpperCase();

		if(db.containsKey(id)) {
			Student s=db.get(id);

			System.out.println("Enter your choice\n1.Update name\n2.Update marks\n3.Update age");
			int choice=scan.nextInt();

			switch(choice) {
			case 1:System.out.println("Enter new name");
			String name=scan.next();
			s.setName(name);//std.setName(scan.next());
			System.out.println("Name updated successfully");
			break;

			case 2:System.out.println("Enter new marks");
			int marks=scan.nextInt();
			s.setMarks(marks);//std.setInt(scan.nextInt());
			System.out.println("Marks updated successfully");
			break;

			case 3:System.out.println("Enter new age");
			int age=scan.nextInt();
			s.setAge(age);
			System.out.println("Age updated successfully");
			break;

			case 4:
				break;
			default:
				try {
					String message="Invalid Choice, Kindly Enter Valid Choice";
					throw new InvalidChoiceException(message);
				}
				catch( InvalidChoiceException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new StudentNotFountException("Student with the id "+id+"  not found!!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void countStudents() 
	{
		System.out.println("NUmber of Student records :"+db.size());
	}


	@Override
	public void sortStudents() 
	{
		//reference of list &object od Arraylist storing student objects
		List<Student> l=new ArrayList<Student>();

		//Converting Map into Set using keySet()
		Set<String> keys=db.keySet();

		//Traverse Keys
		for(String key:keys)
		{
			Student std=db.get(key);//getting student object
			l.add(std);//adding student object into list
		}
		System.out.println("1:SortStudentById\n2:SortStudentByAge\n3:SortStudentByName\n4:SortStudentByMarks");
		System.out.println("Enter choice");
		int choice=scan.nextInt();

		switch(choice)
		{
		case 1:
			Collections.sort(l,new SortStudentById());
			for(Student s:l) {
				System.out.println(s);
			}
			break;


		case 2:
			Collections.sort(l,new SortStudentByAge());
			for(Student s:l) {
				System.out.println(s);
			}
			break;

		case 3:
			Collections.sort(l,new SortStudentByName());
			for(Student s:l) {
				System.out.println(s);
			}
			break;
		case 4:
			Collections.sort(l,new SortStudentByMarks());
			for(Student s:l) {
				System.out.println(s);
			}
			break;
		default:
			try {
				String message="Invalid Choice, Kindly Enter Valid Choice";
				throw new InvalidChoiceException(message);
			}
			catch( InvalidChoiceException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void getStudentWithHighestMarks() 
	{
		List<Student> l=new ArrayList<Student>();
		Set<String> keys=db.keySet();

		for(String key:keys)
		{
			Student std=db.get(key);//getting student object
			l.add(std);//adding student object into list
		}
		Collections.sort(l, new SortStudentByMarks());
		System.out.println("Student with Highest Marks:");
		System.out.println(l.get(l.size()-1));

	}


	@Override
	public void getStudentWithLowestMarks()
	{
		List<Student> l=new ArrayList<Student>();
		Set<String> keys=db.keySet();

		for(String key:keys)
		{
			Student std=db.get(key);//getting student object
			l.add(std);//adding student object into list
		}
		Collections.sort(l, new SortStudentByMarks());
		System.out.println("Student with Lowest Marks:");
		System.out.println(l.get(0));

	}


}