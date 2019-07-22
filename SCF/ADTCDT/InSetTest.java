import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class InSetTest {

	// test of set values out of range
	@Test
	public void test_FunctionForSet_Out_Range() {
		 try {
			 InSet setarray= new InSet( new int[]{-1,1002});
		 }
		 catch (Exception e) {
			 assertEquals("Value out of range", e.getMessage());
		 }
	}

	
	@Test
	public void test_FunctionFor_LengthOfSet()throws Exception  {

			 InSet setarray= new InSet( new int[]{6,7,8,10});
			 int returnedValue =setarray.size(); 
			 int expectedValue = 4;
			 Assert.assertEquals( expectedValue, returnedValue );
	}

	 
	@Test
	public void test_FunctionFor_FindMember() throws Exception {
			 InSet setarray= new InSet( new int[]{1,2,3,4,5});
			 assertTrue(setarray.isMember(4) );	 
	}

	
	@Test
	public void test_FunctionFor_FindNonExistingElement() throws Exception {
			 InSet setarray= new InSet( new int[]{1,2,3,4,5});
			 assertFalse(setarray.isMember(8) );	 
	}

	 
	 @Test
	   public void test_FunctionFor_FindSubsetPresent() throws Exception{	
		 InSet setarray= new InSet( new int[]{1,2,3,4,5});
		 InSet subsetarray= new InSet( new int[]{1,2,3});
		 assertTrue(setarray.isSubSet(subsetarray));	   
	   }

 	 
	 @Test
	   public void test_FunctionFor_FindSubsetNotPresent() throws Exception{	
		 InSet setarray= new InSet( new int[]{1,2,3,4,5});
		 InSet subsetarray= new InSet( new int[]{7,8});
		 assertFalse(setarray.isSubSet(subsetarray));	   
	   }


	 @Test
	   public void test_FunctionForCheck_SubsetNull() throws Exception{	
		 InSet setarray= new InSet( new int[]{1,2,3,4,5});
		 InSet subsetarray= new InSet( new int[]{});
		 assertTrue(setarray.isSubSet(subsetarray));	   
	   }

	
	 @Test
	   public void test_FunctionFor_UnionSetSame() throws Exception{
		 InSet setarray1= new InSet( new int[]{1,2,3});
		 InSet setarray2= new InSet( new int[]{1,2,3});
		 int returnedArrOperation[] =setarray1.unionSet(setarray1,setarray2); 
		 int []expectedArr = new int[] {1,2,3};
		 Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }

	 @Test
	   public void test_FunctionFor_UnionSetDifferent() throws Exception{
		 InSet setarray1= new InSet( new int[]{1,2,3});
		 InSet setarray2= new InSet( new int[]{4,5,6});
		 int returnedArrOperation[] =setarray1.unionSet(setarray1,setarray2); 
		 int []expectedArr = new int[] {1,2,3,4,5,6};
		 Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }

	 @Test
	   public void test_FunctionFor_UnionSetMixture() throws Exception{
		 InSet setarray1= new InSet( new int[]{1,2,3});
		 InSet setarray2= new InSet( new int[]{2,3,5,6});
		 int returnedArrOperation[] =setarray1.unionSet(setarray1,setarray2); 
		 int []expectedArr = new int[] {1,2,3,5,6};
		 Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }

	 @Test
	   public void test_FunctionFor_UnionSetNull() throws Exception{
		 InSet setarray1= new InSet( new int[]{1,2,3});
		 InSet setarray2= new InSet( new int[]{});
		 int returnedArrOperation[] =setarray1.unionSet(setarray1,setarray2); 
		 int []expectedArr = new int[] {1,2,3};
		 Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }
}