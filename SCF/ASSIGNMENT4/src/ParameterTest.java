import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)

public class ParameterTest {
	   private int[] inputNumber;
	   private int expectedResult;
	   private ArrOperation arrOperation;

	   @Before
	   public void initialize() {
	     arrOperation = new ArrOperation();
	   }
	   
	   public ParameterTest(int[] inputNumber , int expectedNumber) {
		// TODO Auto-generated constructor stub
		   this.inputNumber = inputNumber;
		   this.expectedResult = expectedNumber;
	}
	   
	   @Parameterized.Parameters
	   public static Collection maxMirror() {
	      return Arrays.asList(new Object[][] {
	         {new int[] {1, 2, 3, 8, 9, 3, 2, 1},3 },
	         {new int[] {7,1,4,9,7,4,1}, 2 },
	         { new int[]{1, 2, 1,4}, 3 },
	         { new int[]{1, 4, 5, 3, 5, 4, 1}, 7 },
	         { new int[]{1, 4, 5, 3, 5, 4, 1}, 7 }
	         
	      });
	   }
	   
	   @Test
	   public void testMaxMirror1() throws Exception {	  
	      assertEquals(expectedResult,arrOperation.maxMirror(inputNumber));
	   }
}