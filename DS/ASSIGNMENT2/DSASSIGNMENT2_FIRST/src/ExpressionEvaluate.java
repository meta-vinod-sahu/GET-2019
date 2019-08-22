import java.util.HashMap;


/**
 * this class contain method for evaluation of getting expression
 */
public class ExpressionEvaluate {
	
	    // Hashmap for set priority of operator
		private static HashMap<String,Integer> precedenceSetter = new HashMap<String, Integer>();
	
		public ExpressionEvaluate() {
		 
			ExpressionEvaluate.set_OperatorPrecedence_function();
	    }
		
		
		
		

		/**
		 * Method for set precedence for all operator
		 */
		private static void set_OperatorPrecedence_function() {
			
			ExpressionEvaluate.precedenceSetter.put("||",1);
			
			ExpressionEvaluate.precedenceSetter.put("&&",2);
			ExpressionEvaluate.precedenceSetter.put("==",3);
			ExpressionEvaluate.precedenceSetter.put("!=",3);
			ExpressionEvaluate.precedenceSetter.put("<",4);
			ExpressionEvaluate.precedenceSetter.put(">",4);
			ExpressionEvaluate.precedenceSetter.put("<=",4);
			ExpressionEvaluate.precedenceSetter.put(">=",4);
			ExpressionEvaluate.precedenceSetter.put("+",5);
			ExpressionEvaluate.precedenceSetter.put("-",5);
			ExpressionEvaluate.precedenceSetter.put("*",6);
			ExpressionEvaluate.precedenceSetter.put("/",6);
			ExpressionEvaluate.precedenceSetter.put("!",7);
			
		}
        
		/**
		 * method for evaluating infix expression
		 * @param take infixExpression parameter of string type
		 * @return return the result of infix evaluation
		 * @throws Exception 
		 */
		public int function_for_EvaluateInfixExpression(String infixExpression) throws Exception{
			
			String postfixEvaluation = infixToPostfixConversion(infixExpression);
			
			int result_Of_postfixEvaluation = postfixEvaluation(postfixEvaluation);
			
			return result_Of_postfixEvaluation;
		}



        /**
         * method for convert infix to postfix conversion
         * @param take string infixExpression expression 
         * @return string of postfix expression
         * @throws Exception 
         */
        private String infixToPostfixConversion(String infixExpression) throws Exception {
        	
        	//adding  parentheses to both side
    		infixExpression = "( "+infixExpression+" )";
    		
    		//CustomStack object 
    		StackOperation operatorStack=new StackOperation();
    		
    		//StrigBuilder which will contain postfix expression
    		StringBuilder postfixExpression =new StringBuilder();
    		
    		//getting array of individual tokens
    		String[] expressionArray = infixExpression.split(" ");
    		try{

    			for(int indexFirst=0; indexFirst < expressionArray.length; indexFirst++) {

    				//if number arrived add to postfix expression
    				if(expressionArray[indexFirst].charAt(0) >= '0' && expressionArray[indexFirst].charAt(0) <= '9') {
    					//postfixExpression = postfixExpression + expressionArray[indexFirst]+" ";
    					postfixExpression.append(expressionArray[indexFirst]+" ");
    				}
    				else {
    					//first operator comes in stack
    					if(operatorStack.topOfStack==-1){
    						operatorStack.push(expressionArray[indexFirst]);
    					}
    					//if operator comes and top of stack has '('
    					else if( operatorStack.peek().equals("(") && (!expressionArray[indexFirst].equals(")"))){
    						operatorStack.push(expressionArray[indexFirst]);
    					}
    					//if greater priority operator comes 
    					else if((!expressionArray[indexFirst].equals(")"))  && (!expressionArray[indexFirst].equals("(")) && isFirstOperatorGreater(expressionArray[indexFirst],operatorStack.peek())) {
    						operatorStack.push(expressionArray[indexFirst]);
    					}
    					//if same priority operator comes
    					else if((!expressionArray[indexFirst].equals(")"))  && (!expressionArray[indexFirst].equals("(")) && (isPriorityEqual(expressionArray[indexFirst],operatorStack.peek()))) {
    						//postfixExpression = postfixExpression + operatorStack.stack.get(operatorStack.topOfStack)+" ";
    						postfixExpression.append(operatorStack.stack.get(operatorStack.topOfStack)+" ");
    						operatorStack.pop();
    						--indexFirst;
    					}
    					//if ')' comes
    					else if(expressionArray[indexFirst].equals(")")) {
    						while(!operatorStack.peek().equals("(")) {
    							//postfixExpression = postfixExpression + operatorStack.stack.get(operatorStack.topOfStack)+" ";
    							postfixExpression.append(operatorStack.peek()+" ");
    							operatorStack.pop();
    						}
    						operatorStack.pop();
    						if(operatorStack.topOfStack==-1){ break; }
    					}
    					//if '(' comes
    					else if(expressionArray[indexFirst].equals("(")) {
    						operatorStack.push(expressionArray[indexFirst]);
    					}
    					//if lesser priority operator comes
    					else {
    						//postfixExpression = postfixExpression +operatorStack.stack.get(operatorStack.topOfStack)+" ";
    						postfixExpression.append(operatorStack.peek()+" ");
    						operatorStack.pop();
    						--indexFirst;
    					}
    				}
    			} 		
    			return postfixExpression.toString();

    		}catch(Exception e){
    			System.out.println(e);
    		}
    		return "";
        	
			
			                                                                    
		}

        /**
    	 * Checks for if First Operator Priority Greater
    	 * @param String type operator First
    	 * @param String type operator Second
    	 * @return boolean true if First Operator Priority is Greater else false
    	 */
    	private boolean isFirstOperatorGreater(String firstOperstor,String secondOperator) {

    		if( ExpressionEvaluate.precedenceSetter.get(firstOperstor) > ExpressionEvaluate.precedenceSetter.get(secondOperator) )
    		{ return true; }
    		else 
    		{ return false; }
    	}

    	/**
    	 * Checks for if Priorities are Equal
    	 * @param String type operator First
    	 * @param String type operator Second
    	 * @return boolean true if First Operator Priority is Equal to Second Operators Priority else false
    	 */
    	private boolean isPriorityEqual(String firstOperstor,String secondOperator) {

    		if( ExpressionEvaluate.precedenceSetter.get(firstOperstor) == ExpressionEvaluate.precedenceSetter.get(secondOperator) )
    		{ return true;}
    		else { return false; }
    	}





		/**
		 * method for evaluating postfix expression
		 * @param take string postfixEvaluation as parameter
		 * @return integer value of evaluate result
		 */
		private int postfixEvaluation(String postfixEvaluation) {
			String extractedCharacters[] = postfixEvaluation.split(" ");
			StackOperation operandStack = new StackOperation();

			for(int indexFirst=0;indexFirst < extractedCharacters.length; indexFirst++){

				String extractedCharacter = extractedCharacters[indexFirst];
				try{
					if(extractedCharacter.charAt(0)>='0' && extractedCharacter.charAt(0)<='9'){ operandStack.push(extractedCharacter); }
					else{
						if(extractedCharacter.equals("!")){
							//String operandFirst=operandStack.stack.get(operandStack.topOfStack);
							String operandFirst=operandStack.pop();
							operandStack.push(Integer.toString(evaluateExpression(Integer.parseInt(operandFirst),0,extractedCharacter)));
						}
						else{
							//String operandSecond=operandStack.stack.get(operandStack.topOfStack);
							String operandSecond=operandStack.pop();
							//String operandFirst=operandStack.stack.get(operandStack.topOfStack);
							String operandFirst=operandStack.pop();
							operandStack.push(Integer.toString(evaluateExpression(Integer.parseInt(operandFirst), Integer.parseInt(operandSecond), extractedCharacter)));
						}
					}
				}catch(Exception e){
					System.out.println(e);
				}
			}
			return Integer.parseInt(operandStack.stack.get(operandStack.topOfStack));
			
		}





		/**
		 * @param operandFirst
		 * @param operandSecond
		 * @param extractedCharacter
		 * @return
		 */
		private int evaluateExpression(int operandFirst, int operandSecond,String extractedCharacter) {
			switch(extractedCharacter){

			case "+":{
				return ( operandFirst + operandSecond );
			}
			case "-":{
				return ( operandFirst - operandSecond );
			}
			case "*":{
				return ( operandFirst * operandSecond );
			}
			case "/":{
				return ( operandFirst / operandSecond );
			}
			case "==":{
				if( operandFirst == operandSecond ){
					return 1;
				}
				return 0;	
			}	
			case "!=":{
				if( operandFirst == operandSecond ){
					return 0;
				}
				return 1;
			}
			case "<":{
				if( operandFirst < operandSecond ){
					return 1;
				}
				return 0;	
			}
			case ">":{
				if( operandFirst > operandSecond ){
					return 1;
				}
				return 0;	
			}
			case "<=":{
				if( operandFirst <= operandSecond ){
					return 1;
				}
				return 0;	
			}
			case ">=":{
				if( operandFirst >= operandSecond ){
					return 1;
				}
				return 0;
			}
			case "&&":{
				if( ( operandFirst > 0 ) && ( operandSecond > 0 ) ){
					return 1;
				}
				return 0;
			}
			case "||":{
				if( ( operandFirst > 0 ) || ( operandSecond > 0 ) ){
					return 1;
				}
				return 0;
			}
			case "!":{
				if( operandFirst > 0 ){
					return 0;
				}
				return 1;
			}
			}		
			return 0;
		}





		
	
	
	

}
