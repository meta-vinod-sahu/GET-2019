public class Bowler {
	int balls;
	String name;

	public Bowler(int balls, String name) {
		if (balls == 0) {
			throw new AssertionError("Bowler Can't Bowl");
		}
		if (name == null) {
			throw new NullPointerException("Bowler Name can't be Null");
		}
		this.balls = balls;
		this.name = name;
	}

	public void setBalls(int balls) {
		if (balls >= 0) {
			this.balls = balls;
		} else {
			throw new AssertionError("Balls can't be negative in number");
		}
	}

	public int getBalls() {
		return balls;
	}

	public String getBowler() {
		return name;
	}
}