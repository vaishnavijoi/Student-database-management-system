package customSorting;

import java.util.Comparator;

import studentDatabaseManagementSystem.Student;

public class SortStudentByMarks implements Comparator<Student>{

	public int compare(Student x,Student y)
	{
		return x.getMarks()-y.getMarks();
	}

}