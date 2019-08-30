
public interface Stack {
	
	/**
	 * This method push element to stack
	 * @param element to be added in queue
	 * @return boolean value
	 * @throws Exception
	 */
	public boolean push(String element) throws Exception; 
	/**
	 * This method pop out element form the stack
	 * @return string element from the top of the stack
	 * @throws Exception
	 */
	public String pop() throws Exception;
	
	/**
	 * This method check stack is empty or not
	 * @return boolean value
	 */
	public boolean isEmpty();
	
	/**
	 * this method give value of the top of the stack
	 * @return string String value from the top of the stack
	 * @throws Exception
	 */
	public String peek() throws Exception;
}
