import static org.junit.Assert.*;

import org.junit.Test;


public class TestCases {

	@Test
	public void testAddEmployee() {
		EmployeeOperation empList = new EmployeeOperation();
		assertEquals(true,empList.addEmployee(3, "dimansh", "jaipur"));
		assertEquals(true,empList.addEmployee(1, "vinod" , "toda"));
		assertEquals(true,empList.addEmployee(2, "prabhav" , "bara"));
		assertEquals(true,empList.addEmployee(4, "kratik", "udaipur"));
		assertEquals(true,empList.addEmployee(0, "shoaid", "toda"));
		
	}
	
	@Test(expected = AssertionError.class)
	public void testAddEmployeeAlreadyExist() {
		EmployeeOperation empList = new EmployeeOperation();
		empList.addEmployee(1, "vinod" , "toda");
		empList.addEmployee(2, "prabhav" , "bara");
		empList.addEmployee(3, "dimansh", "jaipur");
		empList.addEmployee(1, "pratap" , "bhilwara");
		assertEquals(true,empList.addEmployee(1, "pratap" , "bhilwara"));
	}
	
	@Test
	public void testDeleteEmployee(){
		EmployeeOperation empList = new EmployeeOperation();
		assertEquals(true,empList.addEmployee(1, "vinod" , "toda"));
		assertEquals(true,empList.addEmployee(2, "prabhav" , "bara"));
		assertEquals(true,empList.addEmployee(3, "dimansh", "jaipur"));
		assertEquals(true,empList.deleteEmployee(2));
	    assertEquals(false,empList.deleteEmployee(5));
		
	}
	
	@Test
	public void testSortEmployeeById() {
		EmployeeOperation empList = new EmployeeOperation();
		assertEquals(true,empList.addEmployee(777777, "naman" , "tonk"));
		assertEquals(true,empList.addEmployee(1, "shoaid", "toda"));
		assertEquals(true,empList.addEmployee(333, "dimansh", "jaipur"));
		assertEquals(true,empList.addEmployee(22, "vinod" , "toda"));
		assertEquals(true,empList.addEmployee(666666, "prabhav" , "bara"));
		assertEquals(true,empList.addEmployee(55555, "kratik", "udaipur"));	
		assertEquals(true,empList.addEmployee(4444, "aqib" , "bikaner"));
		empList.showEmployee();
		empList.sortById();
		
	}
	
	@Test
	public void testSortEmployeeByName() {
		EmployeeOperation empList = new EmployeeOperation();
		assertEquals(true,empList.addEmployee(777777, "muzi" , "tonk"));
		assertEquals(true,empList.addEmployee(1, "shoaid", "toda"));
		assertEquals(true,empList.addEmployee(333, "dimansh", "jaipur"));
		assertEquals(true,empList.addEmployee(22, "vinod" , "toda"));
		assertEquals(true,empList.addEmployee(666666, "prabhav" , "bara"));
		assertEquals(true,empList.addEmployee(55555, "kratik", "udaipur"));	
		assertEquals(true,empList.addEmployee(4444, "aqib" , "bikaner"));
		empList.showEmployee();
		empList.sortByName();
	}
}