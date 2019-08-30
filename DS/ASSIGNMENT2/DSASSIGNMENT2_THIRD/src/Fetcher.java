import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Class provides Methods To fetch the data
 */
public class Fetcher 
{
	private List<Program> programs;
	private List<Student> students;
	public Fetcher() 
	{
		programs = new ArrayList<Program>();
		students = new ArrayList<Student>();	
	}
	
	public List<Program> getPrograms() 
	{
		return programs;
	}

	public void setPrograms(List<Program> programs) 
	{
		this.programs = programs;
	}

	public List<Student> getStudents() 
	{
		return students;
	}

	public void setStudents(List<Student> students) 
	{
		this.students = students;
	}
	
	/**
	 * set programs.xls sheet data into program list 
	 * @param fileSource string of program.xls
	 * @return list of branches/program
	 */
	public void fetchPrograms(String fileSource)
	{	
		Workbook workbook = null; 
		try
		{			
			workbook = Workbook.getWorkbook(new File(fileSource));
			Sheet sheet = workbook.getSheet(0);
			Cell cell;
			Program program;
			int rows = sheet.getRows();
			for(int i=0; i<rows; i++)
			{   
				program = new Program();
				cell = sheet.getCell(0,i);		
				program.setProgramName(cell.getContents());
				cell = sheet.getCell(1,i);
				program.setAvailableSeatsInProgram(Integer.parseInt(cell.getContents()));
				programs.add(program);
			}
		}
		catch (IOException e) 
		{
            e.printStackTrace();
        } 
		catch (BiffException e) 
		{
            e.printStackTrace();
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * set student.xls sheet data into program list 
	 * @param fileSource string of student.xls
	 * @return list of student
	 */
	public void fetchStudents(String fileSource)
	{
		Workbook workbook = null; 		
		try{
			workbook = Workbook.getWorkbook(new File(fileSource));
			Sheet sheet = workbook.getSheet(0);
			Cell cell;
			Student student; 
			int rows = sheet.getRows();	
			for(int i=0; i<rows; i++)
			{				
				student = new Student();
		 		cell = sheet.getCell(0,i);   
				student.setName(cell.getContents());
				
				cell = sheet.getCell(1,i);
				student.getPrograms().add(cell.getContents());
				
				cell = sheet.getCell(2,i);
				student.getPrograms().add(cell.getContents());
				
				cell = sheet.getCell(3,i);
				student.getPrograms().add(cell.getContents());
				
				cell = sheet.getCell(4,i);
				student.getPrograms().add(cell.getContents());
				
				cell = sheet.getCell(5,i);
				student.getPrograms().add(cell.getContents());
				
				students.add(student);
			}
		}
		catch (IOException e) 
		{
            e.printStackTrace();
        } catch (BiffException e) 
		{
            e.printStackTrace();
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
