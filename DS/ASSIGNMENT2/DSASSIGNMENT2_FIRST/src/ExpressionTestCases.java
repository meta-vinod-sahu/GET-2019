import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class ExpressionTestCases {
	//object of ExpressionEvaluator class
		static ExpressionEvaluate expressionEvaluator;
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			expressionEvaluator = new ExpressionEvaluate();
		}

		/**
		 * This method is testing  infixExprssionEvaluatot method of ExpressionEvaluator class
		 * @throws Exception 
		 */
		@Test
		public void infixExpressionEvaluatorMethodTest() throws Exception {
		String infixExpression1 = "1 + 2";
		String infixExpression2 = "( 5 * 6 ) / 5";
		String infixExpression3 = "3 && 4";
		String infixExpression4 = "7 || 9";
		String infixExpression5 = "( 5 - 2 ) * 3";
		String infixExpression6 = "( 3 < 6 ) * 6";
		String infixExpression7 = "( 7 > 9 )";
		String infixExpression8 = "7 >= 9";
		String infixExpression9 = "7 <= 9";
		String infixExpression10 = "! 6";
		String infixExpression11 = "5 == 5";
		
		assertEquals(3,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression1));
		assertEquals(6,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression2));
		assertEquals(1,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression3));
		assertEquals(1,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression4));
		assertEquals(9,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression5));
		assertEquals(6,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression6));
		assertEquals(0,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression7));
		assertEquals(0,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression8));
		assertEquals(1,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression9));
		assertEquals(0,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression10));
		assertEquals(1,expressionEvaluator.function_for_EvaluateInfixExpression(infixExpression11));
		
		
		}
}
