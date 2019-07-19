
public class LcmHcmOperation {
	
	/*
	 * @param num1 and @param num2 are two positive integers whose hcf is to be calculated
	 * @return returns hcf of num1 and num2
	 */
	public static int findHcf(int num1, int num2) throws Exception {
		if(num2==0)
			return num1;
		else if(num1==0 && num2==0)
			throw new Exception("Divide By Zero");
		else if(num1==0)
			return num2;
		return findHcf( num2 % num1 , num1  );  
	}

	/*
	 * @param num1 and @param num2 are two positive integers whose lcm is to be calculated
	 * @return returns lcm of num1 and num2
	 */
	public static int findLcm(int num1, int num2) throws Exception {
		int hcf=(int)findHcf(num1,num2);
		if(hcf==0)
			throw new Exception("Divide By Zero");
		return ((num1*num2)/hcf);  
	}
	
	 public static void main(String[] args)  
	    { 
	        int a = 20, b = 15; 
	        try {
				System.out.println(findLcm(a, b));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }

	

}
