package customSorting;

import java.util.Comparator;

import studentDatabaseManagementSystem.Student;

public class SortStudentByAge implements Comparator<Student> {

	public int compare(Student x,Student y)
	{
		return x.getAge()-y.getAge();
	}
}

