
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.File;
import java.util.*;

public class ProgramAllocator 
{
	private Queue<Student> studentQueue;	
	/**
	 * method for allocate seat to student according to insert in queue
	 * @param allPrograms list
	 * @param students list
	 * @param fileDestination
	 * @return result true and false
	 */
	public boolean allocator(List<Program> allPrograms, List<Student> students, String fileDestination)
	{
		studentQueue = new Queue<Student>(students.size());
		WritableWorkbook workbook = null;
		boolean flag =false;
		for(Student student: students)
		{
			studentQueue.enqueue(student);
		}
		
		try{
			workbook = Workbook.createWorkbook(new File(fileDestination));
			WritableSheet sheet = workbook.createSheet("Allocation", 0);	
			Label label;
			int row = 0;
			while(!studentQueue.isEmpty())
			{
				Student student = studentQueue.dequeue();	
			    label = new Label(0,row,student.getName());	
				sheet.addCell(label);
				//check for all branch in precedence order
				for (String program : student.getPrograms()) 
				{
					if (isProgramAvailable(program, allPrograms)) 
					{
						label = new Label(1, row, program + "(Allocated)");
						sheet.addCell(label);
						flag = true;
						break;
					}
				}
				row++;
			}
			workbook.write();
			workbook.close();
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
		
    }
	
	/**
	 * method for check seat is available or not
	 * @param programToCheck
	 * @param allPrograms
	 * @return boolean value
	 */
	public boolean isProgramAvailable(String programToCheck, List<Program> allPrograms) {
		boolean result = false;
		for (Program program : allPrograms)
		{
			if (program.getProgramName().equals(programToCheck) && program.getAvailableSeatsInProgram() > 0) 
			{
				program.setAvailableSeatsInProgram(program.getAvailableSeatsInProgram() - 1);
				result = true;
			}
		}
		return result;
	}
}
