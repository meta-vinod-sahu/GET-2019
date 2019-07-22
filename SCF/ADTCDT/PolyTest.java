import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PolyTest {

	@Test
	public void test_Empty_Array() {
		try {
			new Poly(new int[] {});
		} catch (Exception e) {
			assertEquals("Empty Polynomial Array", e.getMessage());
		}
	}

	@Test
	public void test_Evaluate_Positive() throws Exception {
		Assert.assertEquals(73.00,
				new Poly(new int[] { 1, 0, 2, 0, 4 }).evaluate(2), 0.0f);
	}

	@Test
	public void test_Degree_Positive() throws Exception {
		assertEquals(3, new Poly(new int[] { 0, 1, 0, 5 }).degree());
	}

	@Test
	public void test_Add_Polyinomial() throws Exception {
		int returnedArrOperation[] = new Poly(new int[] { 1, 0, 2, 0, 4 })
				.addPoly(new Poly(new int[] { 1, 0, 2, 0, 4 }), new Poly(
						new int[] { 0, 1, 0, 5 }));
		int[] expectedArr = new int[] { 1, 1, 2, 5, 4 };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	@Test
	public void test_Multiply_Polyinomial() throws Exception {
		int returnedArrOperation[] = new Poly(new int[] { 1, 0, 2, 0, 4 })
				.multiplyPoly(new Poly(new int[] { 1, 0, 2, 0, 4 }), new Poly(
						new int[] { 0, 1, 0, 5 }));
		int[] expectedArr = new int[] { 0, 1, 0, 7, 0, 14, 0, 20, 0, 0, 0, 0, 0 };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}
}