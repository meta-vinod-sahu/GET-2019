import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class NQueenTestCases {
	
	NQueenBoard Queen = new NQueenBoard(); 

	@Test
	public void testsolveNQ() {
	   try { 
		   Queen.solveNQ(0);
	   }
	   catch (Exception e) {
		   assertEquals("Zero no. of Queens", e.getMessage());
	   }
	}

	@Test
	   public void testsolveNQ_positive() throws Exception{	  
		   assertTrue(Queen.solveNQ(4) );
	 }

	 @Test
	   public void testsolveNQ_negative() throws Exception{	  
		   assertFalse(Queen.solveNQ(3) );
	 }
}
