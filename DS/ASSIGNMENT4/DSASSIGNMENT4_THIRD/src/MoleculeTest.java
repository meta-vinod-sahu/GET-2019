import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MoleculeTest {

	@Test
	public void test() {
		OrganicMoleculeMass obj = new OrganicMoleculeMass();
		String compound = "ch3";
		assertEquals(15, obj.evaluate(compound));
		compound = "CHOC(CH3)3";
		assertEquals(86, obj.evaluate(compound));
		compound = "C12H10";
		assertEquals(154, obj.evaluate(compound));
	}

	@Test(expected = NullPointerException.class)
	public void nulltest() {
		OrganicMoleculeMass obj = new OrganicMoleculeMass();
		assertEquals(15, obj.evaluate(null));
	}
}