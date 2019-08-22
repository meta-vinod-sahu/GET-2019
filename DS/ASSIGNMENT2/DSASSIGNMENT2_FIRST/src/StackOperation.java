import java.awt.List;
import java.util.LinkedList;


/**
 * 
 *This class create user stack and implement stack interface
 */

public class StackOperation implements Stack{
	
	public LinkedList<String> stack = new LinkedList<String>();
	public int topOfStack = -1;
	public int MAX_SIZE_STACK = 100;
	 
	
	
	/**
	 * @param take element to push into stack
	 * @return boolean value  
	 * @throws Exception
	 */
	@Override
	public boolean push(String element) throws Exception {
		
		boolean flag = false;
		if((this.topOfStack + 1) == MAX_SIZE_STACK ) throw new Exception("stack is full");
		else{
			this.topOfStack++;
			this.stack.add(element);
			flag = true;
		}
		
		return flag;
	}

	/**
	 * @return string element from the top of the stack
	 * @throws Exception
	 */
	@Override
	public String pop() throws Exception {
		String element="";
		if(this.stack.isEmpty()) throw new Exception("stach is already empty");
		else{
			element = this.stack.get(topOfStack);
			this.stack.remove(topOfStack);
			this.topOfStack--;
		}
		return element;
	}

	/**
	 * check stack is empty or not
	 * @return boolean value
	 */
	@Override
	public boolean isEmpty() {
	    boolean flag =false;
		if(this.topOfStack == -1) flag =true;
		return flag;
	}

	/**
	 * @return string value of the top of the stack
	 * @throws Exception
	 */
	@Override
	public String peek() throws Exception {
		if(topOfStack == -1) throw new Exception("stack underflow");
		return this.stack.get(topOfStack);
	}

}
