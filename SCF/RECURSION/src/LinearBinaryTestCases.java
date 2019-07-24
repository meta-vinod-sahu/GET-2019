import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class LinearBinaryTestCases {
	LinearBinarySearch s = new LinearBinarySearch();

	@Test
	public void test_LinearSearchfunction_EmptyArray() {
		 try {
			 s.linearSearch(new int[]{}, 5, 8);
		 }
		 catch (Exception e) {
			 assertEquals("Empty Array", e.getMessage());
		 }
	}

	@Test
	public void test_LinearSearchFunction_IndexOutOfBound() {
		 try {
			 s.linearSearch(new int[]{1,2,3}, 5, 8);
		 }
		 catch (Exception e) {
			 assertEquals("Array Index Out Of Bound", e.getMessage());
		 }
	}

	@Test
	public void test_LinearSearchFunction_PositiveInput() throws Exception {
		 assertEquals(2,s.linearSearch(new int[]{1,2,3,4,5},0,3));  
	}

	@Test
	public void test_LinearSearchFunction_NegativeInput() throws Exception {
		 assertEquals(-1,s.linearSearch(new int[]{1,2,3,4,5}, 5,9));  
	}

	@Test
	public void test_BinarySearchFunction_EmptyArray() {
		 try {
			 s.binarySearch(new int[]{},0, 5, 8);
		 }
		 catch (Exception e) {
			 assertEquals("Empty Array", e.getMessage());
		 }
	}

	@Test
	public void test_BinarySearchFunction_IndexOutOfBound() {
		 try {
			 s.binarySearch(new int[]{1,2,3},-6, 5, 8);
		 }
		 catch (Exception e) {
			 assertEquals("Array Index Out Of Bound", e.getMessage());
		}
	}

	@Test
	public void test_BinarySearchFunction_PositiveInput() throws Exception {
		 assertEquals(2,s.binarySearch(new int[]{1,2,3,4,5},0,5,3));  
	}

	@Test
	public void test_BinarySearchFunction_NegativeInput() throws Exception {
		 assertEquals(-1,s.binarySearch(new int[]{1,2,3,4,5},0,5,9));  
	}
}
