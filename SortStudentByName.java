package customSorting;

import java.util.Comparator;

import studentDatabaseManagementSystem.Student;

public class SortStudentByName implements Comparator<Student>{

	public int compare(Student x, Student y)
	{
		return x.getName().compareTo(y.getName());
	}
}
