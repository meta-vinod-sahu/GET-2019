import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class TestJunit {

	ArrOperation arr_operation = new ArrOperation();

	@Test
	public void test_MaxMirrorFunction_WhenArrayIsEmpty() {
		try {
			arr_operation.splitArray(new int[] {});
		} catch (Exception e) {
			assertEquals("Empty Array", e.getMessage());
		}
	}

	@Test
	public void test_SplitArrayfunction_WhenArrayIsEmpty() {
		try {
			arr_operation.splitArray(new int[] {});
		} catch (Exception e) {
			assertEquals("Empty Array", e.getMessage());
		}
	}

	@Test
	public void test_CountClumsFunction_WhenArrayIsEmpty() {
		try {
			arr_operation.countClumps(new int[] {});
		} catch (Exception e) {
			assertEquals("Empty Array", e.getMessage());
		}
	}

	@Test
	public void test_fixXYArrayFunction_WhenArrayIsEmpty() {
		try {
			arr_operation.fixXY(new int[] {}, 4, 5);
		} catch (Exception e) {
			assertEquals("Empty Array", e.getMessage());
		}
	}

	@Test
	public void test_MaxMirrorExample1() throws Exception {
		assertEquals(3,
				arr_operation.maxMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }));
	}

	@Test
	public void test_MaxMirrorExample2() throws Exception {
		assertEquals(2,
				arr_operation.maxMirror(new int[] { 7, 1, 4, 9, 7, 4, 1 }));
	}

	@Test
	public void test_MaxMirrorExample3() throws Exception {
		assertEquals(3, arr_operation.maxMirror(new int[] { 1, 2, 1, 4 }));
	}

	@Test
	public void test_MaxMirrorExample4() throws Exception {
		assertEquals(7,
				arr_operation.maxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 }));
	}

	@Test
	public void test_CountClumpsExample1() throws Exception {
		assertEquals(2,
				arr_operation.countClumps(new int[] { 1, 2, 2, 3, 4, 4 }));
	}

	@Test
	public void test_CountClumpsExample2() throws Exception {
		assertEquals(2, arr_operation.countClumps(new int[] { 1, 1, 2, 1, 1 }));
	}

	@Test
	public void test_CountClumpsExample3() throws Exception {
		assertEquals(1, arr_operation.countClumps(new int[] { 1, 1, 1, 1, 1 }));
	}

	@Test
	public void test_SplitArrOperationFunctionExapmle1() throws Exception {
		assertEquals(3, arr_operation.splitArray(new int[] { 1, 1, 1, 2, 1 }));
	}

	@Test
	public void test_SplitArrOperationFunctionExapmle2() throws Exception {
		assertEquals(-1, arr_operation.splitArray(new int[] { 2, 1, 1, 2, 1 }));
	}

	@Test
	public void test_SplitArrOperationFunctionExapmle3() throws Exception {
		assertEquals(1, arr_operation.splitArray(new int[] { 10, 10 }));
	}

	@Test
	public void test_fixXYFunction_WhenNumberAreUnequal() {
		try {
			arr_operation.fixXY(new int[] { 4, 5, 2, 4, 2 }, 4, 5);
		} catch (Exception e) {
			assertEquals("unequal numbers of X and Y in input array",
					e.getMessage());
		}
	}

	@Test
	public void test_fixXYFunction_WhenTwoAdjacentPresent() {
		try {
			arr_operation.fixXY(new int[] { 4, 4, 5, 5, 3, 1 }, 4, 5);
		} catch (Exception e) {
			assertEquals("two adjacents X values are there", e.getMessage());
		}
	}

	@Test
	public void test_fixXYFunction_WhenXPresentInLastIndex() {
		try {
			arr_operation.fixXY(new int[] { 4, 3, 5, 4, 3, 2, 5, 5, 4 }, 4, 5);
		} catch (Exception e) {
			assertEquals("X occurs at the last index of array", e.getMessage());
		}
	}

	@Test
	public void test_FixXYFunctionExample1() throws Exception {
		int returnedArrOperation[] = arr_operation.fixXY(new int[] { 5, 4, 9,
				4, 9, 5 }, 4, 5);
		int[] expectedArr = new int[] { 9, 4, 5, 4, 5, 9 };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	@Test
	public void test_FixXYFunctionExample2() throws Exception {
		int returnedArrOperation[] = arr_operation.fixXY(
				new int[] { 1, 4, 1, 5 }, 4, 5);
		int[] expectedArr = new int[] { 1, 4, 5, 1 };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	@Test
	public void test_FixXYFunctionExample3() throws Exception {
		int returnedArrOperation[] = arr_operation.fixXY(new int[] { 1, 4, 1,
				5, 5, 4, 1 }, 4, 5);
		int[] expectedArr = new int[] { 1, 4, 5, 1, 1, 4, 5 };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

}
