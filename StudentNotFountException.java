package customException;

//		unchecked Exception
public class StudentNotFountException extends RuntimeException 
{
	private String message;
	
	public StudentNotFountException(String message)
	{
		this.message=message;
	}

	public String getMessage()
	{
		return message;
	}


}
