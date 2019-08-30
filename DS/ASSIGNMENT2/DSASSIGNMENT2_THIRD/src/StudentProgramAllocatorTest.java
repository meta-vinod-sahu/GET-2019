import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Main class contain main function
 */
public class StudentProgramAllocatorTest 
{
	/**
	 * This test method test allocator method of ProgramAllocator Class
	 */
	
	@Test
	public void allocateCoursesPositiveCasesTest() {
		
		Fetcher fetcher = new Fetcher();
		String programListDestination="C:/Users/Admin/workspace/DSASSIGNMENT2_THIRD/src/programs.xls";
		String studentListDestination= "C:/Users/Admin/workspace/DSASSIGNMENT2_THIRD/src/students.xls";
		fetcher.fetchPrograms(programListDestination);
		fetcher.fetchStudents(studentListDestination);
		
		ProgramAllocator allocatorObj = new ProgramAllocator();
		assertTrue(allocatorObj.allocator(fetcher.getPrograms() ,fetcher.getStudents(), "C:/Users/Admin/workspace/DSASSIGNMENT2_THIRD/src/AllocatedList.xls"));
		
	}

	
}