public class Program 
{
	private String programName;
	private int availableSeatsInProgram;
	
	/**
	 * method for get program name
	 * @return program name
	 */
	public String getProgramName() {
		return programName;
	}
	
	/**
	 * method for set program name
	 * @param programName
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	/**
	 * method for get know available seat
	 * @return available seat in program
	 */
	public int getAvailableSeatsInProgram() {
		return availableSeatsInProgram;
	}
	
	/**
	 * method for set seat capacity
	 * @param availableSeatsInProgram
	 */
	public void setAvailableSeatsInProgram(int availableSeatsInProgram) {
		this.availableSeatsInProgram = availableSeatsInProgram;
	}
}
