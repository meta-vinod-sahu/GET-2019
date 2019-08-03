import java.util.ArrayList;

public class Student 
{
	private String studentName;
	private ArrayList<String> programPrecedenceList;
	
	Student()
	{
		programPrecedenceList= new ArrayList<String>();
	}
	
	/**
	 * @return name of the student
	 */
	String getName()
	{
		return studentName;
	}
	
	/**
	 * @param studentName set in object of student
	 */
	void setName(String studentName)
	{
		this.studentName = studentName;
	}
	
	/**
	 * @return get program list
	 */
	public ArrayList<String> getPrograms() 
	{
		return programPrecedenceList;
	}

	/**
	 * @param programs list set in student class object
	 */
	public void setPrograms(ArrayList<String> programs) 
	{
		this.programPrecedenceList = programs;
	}
}