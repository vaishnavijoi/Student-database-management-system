package studentDatabaseManagementSystem;

public interface StudentManagementSystem 
{
	
	public void addStudents();
	public void displayStudent();
	public void displayAllStudents();
	public void removeStudents();
	public void removeAllStudents();
	public void updateStudents();
	public void countStudents();
	public void sortStudents();
	public void getStudentWithHighestMarks();
	public void getStudentWithLowestMarks();
	
}
//	All the methods inside interface are automatically public and abstract
