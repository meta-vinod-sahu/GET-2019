import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestCases {
	BowlerStrategy strategy = null;

	@Before
	public void init() {
		strategy = new BowlerStrategy();
		strategy.addBowler(8, "Vinod");
		strategy.addBowler(5, "Naman");
		strategy.addBowler(1, "shoaib");
	}

	@Test
	public void testBowlerStrategy() {
		List<Bowler> names = strategy.batsmanMinimumRun(9);
		List<Bowler> result = new ArrayList<Bowler>();
		result.add(new Bowler(4, "Vinod"));
		result.add(new Bowler(1, "Naman"));
		result.add(new Bowler(1, "Vinod"));
		result.add(new Bowler(1, "Naman"));
		result.add(new Bowler(1, "Vinod"));
		result.add(new Bowler(1, "Naman"));
		for (int i = 0; i < result.size(); i++) {
			assertEquals(names.get(i).getBalls(), result.get(i).getBalls());
			assertEquals(names.get(i).getBowler(), result.get(i).getBowler());
		}
	}

	@Test(expected = AssertionError.class)
	public void bowlerWithZeroBallException() {
		strategy.addBowler(0, "Rajendra");
	}

	@Test(expected = NullPointerException.class)
	public void bowlerWithNullNameException() {
		strategy.addBowler(4, null);
	}

	@Test(expected = AssertionError.class)
	public void ballsToPlayMoreThanDelivered() {
		strategy.batsmanMinimumRun(15);
	}
}