package studentDatabaseManagementSystem;

import java.util.Scanner;
import customException.InvalidChoiceException;

public class Solution 
{
	//3.main class
	public static void main(String[] args) 

	{

		System.out.println("Welcome to Student Database Project");
		System.out.println("-----------------------------------");

		Scanner scan = new Scanner(System.in);

		//		upcasting to achieve
		StudentManagementSystem  sms = new StudentManagementSystemImpl();

		//		infinite loop
		while(true)
		{
			//			Menu Driven programs
			System.out.println(" 1. Add Student\n"
					+" 2.Display Students\n"
					+" 3.Display All Students\n"
					+" 4.Remove Students\n"
					+" 5.Remove All Students\n"
					+" 6.Update Students\n"
					+" 7.Count Students\n"
					+" 8.Sort Students\n"
					+" 9.Get Student With Highest Marks\n"
					+" 10.Get Student With Lowest Marks");
			System.out.println("-----------------------------------");

			System.out.println("Enter your choice :");
			int choice = scan.nextInt();

			switch(choice)
			{
			case 1 :
				sms.addStudents();
				break;

			case 2 :
				sms.displayStudent();
				break;

			case 3 :
				sms.displayAllStudents();
				break;

			case 4 :
				sms.removeStudents();
				break;

			case 5 :
				sms.removeAllStudents();
				break;

			case 6 :
				sms.updateStudents();
				break;

			case 7 :
				sms.countStudents();
				break;

			case 8 :
				sms.sortStudents();
				break;

			case 9 :
				sms.getStudentWithHighestMarks();
				break;

			case 10 :
				sms.getStudentWithLowestMarks();
				break;

			case 11 :
				System.out.println("----------Thank You----------");
				System.exit(0);
				break;

			default :
				try
				{
					String message = "Invalid choice, kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

			}	// end of switch

			System.out.println("-----------------------------------");	

		}  // end of while loop

	}	// end of main()

}	// end of class
