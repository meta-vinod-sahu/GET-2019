import java.util.ArrayList;
import java.util.List;

public class BowlerStrategy {
	private List<Bowler> bowlers = new ArrayList<Bowler>();

	/**
	 * Adds Bowler in bowlers List
	 * @param ball
	 * @param name
	 */
	public void addBowler(int ball, String name) {
		bowlers.add(new Bowler(ball, name));
	}

	/**
	 * Returns Bowler's Order so that Bats-man Score Minimum Run
	 * @return bowler order list
	 */
	public List<Bowler> batsmanMinimumRun(int noOfBalls) {
		List<Bowler> bowlerOrder = new ArrayList<Bowler>();
		if (totalBalls() < noOfBalls) {
			throw new AssertionError(
					"Balls to be Played are more than Balls to be Delivered");
		}
		while (noOfBalls != 0) {
			int bolwerIndex = getMaxBallBolwer();
			String bowler = bowlers.get(bolwerIndex).getBowler();
			int orderSize = bowlerOrder.size();
			if (orderSize == 0) {
				bowlerOrder.add(new Bowler(1, bowler));
			} else if (!bowler.equals(bowlerOrder.get(orderSize - 1)
					.getBowler())) {
				bowlerOrder.add(new Bowler(1, bowler));
			} else {
				bowlerOrder.get(orderSize - 1).setBalls(
						bowlerOrder.get(bowlerOrder.size() - 1).getBalls() + 1);
			}
			bowlers.get(bolwerIndex).setBalls(
					bowlers.get(bolwerIndex).getBalls() - 1);
			noOfBalls--;
		}
		return bowlerOrder;
	}

	/**
	 * Method Gives index of Bowler have maximum balls
	 * @return integer
	 */
	private int getMaxBallBolwer() {
		int numberOfBowlers = bowlers.size();
		// let 1st bowler have max no of balls
		int maxBalls = bowlers.get(0).getBalls();
		int index = 0;
		for (int bowlerIndex = 0; bowlerIndex < numberOfBowlers; bowlerIndex++) {
			int balls = bowlers.get(bowlerIndex).getBalls();
			if (balls > maxBalls) {
				maxBalls = balls;
				index = bowlerIndex;
			}
		}
		return index;
	}

	/**
	 * Calculates Total No of Balls Bowlers can Bowl
	 * @return total no of balls
	 */
	public int totalBalls() {
		int totalBalls = 0;
		for (Bowler bowler : bowlers) {
			totalBalls += bowler.getBalls();
		}
		return totalBalls;
	}
}