import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;
public class MatrixOperationTest {

	
	@Test
	public void test_FunctionFor_MatrixNullArray() {
		 try {
			 new MatrixOperation(null);
		 }
		 catch (Exception e) {
			 assertEquals(" NUll Value Array Passed", e.getMessage());
		 }
	}
	
	
	@Test
	public void test_FunctionFor_MatrixEmptyArray() {
		 try {
			 new MatrixOperation(new int[][]{});
		 }
		 catch (Exception e) {
			 assertEquals(" Empty Array ", e.getMessage());
		 }
	}
	
	
	@Test
	public void test_functionFor_MatrixAdditionOfDifferentSized() {
		 try {
			 	MatrixOperation mo=new MatrixOperation(new int[][]{{2, 3}, {5, 6}, {6, 9}});
				MatrixOperation mo1=new MatrixOperation(new int[][]{{2, 2, 2, 2}, {2, 2, 2, 2}});
				mo.addMatrix(mo, mo1);
		 }
		 catch (Exception e) {
			 assertEquals(" both matrix are of different size can't perform addition operation ", e.getMessage());
		 }
	}

	
	@Test
	public void test_FunctionFor_MatrixNullValuePassed_ForAddition() {
		 try {
			 	new MatrixOperation(new int[][]{{1, 2}, {2, 1}}).addMatrix(null, null);
		 }
		 catch (Exception e) {
			 assertEquals(" NUll Value Object Passed", e.getMessage());
		 }
	}
	

	@Test
	   public void test_FunctionFor_addMatrix() throws Exception{	
			MatrixOperation mo = new MatrixOperation(new int[][]{{2, 3}, {5, 6}, {6, 9}});
			MatrixOperation mo1 = new MatrixOperation(new int[][]{{2, 2}, {2, 2}, {2, 2}});
			int returnedArrOperation[][] = mo.addMatrix(mo, mo1);
		   int [][]expectedArr = new int[][]{{4, 5}, {7, 8}, {8, 11}};
		   Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }
	

	@Test
	public void test_FunctionFor_MatrixMultiplicationOfDifferentSized() {
		 try {
			 	MatrixOperation mo = new MatrixOperation(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
				MatrixOperation mo1 = new MatrixOperation(new int[][]{{2, 2, 2, 2},{2, 2, 2, 2}});
				mo.multiplyMatrix(mo, mo1);
		 }
		 catch (Exception e) {
			 assertEquals(" Multiplication Can't be performed ", e.getMessage());
		 }
	}
	

	@Test
	   public void test_FunctionFor_multiplyMatrix() throws Exception{	
			MatrixOperation mo = new MatrixOperation(new int[][]{{2, 3}, {5, 6}, {6, 9}});
			MatrixOperation mo1 = new MatrixOperation(new int[][]{{2, 2, 2, 2}, {2, 2, 2, 2}});
			int returnedArrOperation[][] = mo.multiplyMatrix(mo, mo1);
		    int [][]expectedArr = new int[][]{{10, 10, 10, 10}, {22, 22, 22, 22}, {30, 30, 30, 30}};
		    Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }
	
	
	@Test
	public void test_functionFor_MatrixNullValuePassed_ForMultiplication() {
		 try {
			 	new MatrixOperation(new int[][]{{1, 2}, {2, 1}}).multiplyMatrix(null, null);
		 }
		 catch (Exception e) {
			 assertEquals(" NUll Value Object Passed", e.getMessage());
		 }
	}
	

	@Test
	   public void test_FunctionFor_TransposeMatrix() throws Exception{	
			MatrixOperation mo = new MatrixOperation(new int[][]{{2, 3}, {5, 6}, {6, 9}});
			int returnedArrOperation[][] = mo.transpose();
		   int [][]expectedArr = new int[][]{{2, 5, 6}, {3, 6, 9}};
		   Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }
	
	
	@Test
	   public void test_FunctionFor_SymmetricMatrix_positive() throws Exception{	
			MatrixOperation mo = new MatrixOperation(new int[][]{{1, 2, 3}, {2, 5, 4}, {3, 4, 9}});
			 assertTrue(mo.Symmetric() );
	   }
	
	@Test
	   public void test_FunctionFor_SymmetricMatrix_Negative() throws Exception{	
			MatrixOperation mo = new MatrixOperation(new int[][]{{2, 3, 1} ,{5, 4, 6}, {7, 8, 9}});
			 assertFalse(mo.Symmetric());
	   }
	@Test
	   public void test_FunctionFor_SymmetricMatrixNegative_RowColumn_NotSame() throws Exception{	
			MatrixOperation mo = new MatrixOperation(new int[][]{{2, 3}, {5, 4}, {4, 9}});
			 assertFalse(mo.Symmetric());
	   }
	
	
	
}