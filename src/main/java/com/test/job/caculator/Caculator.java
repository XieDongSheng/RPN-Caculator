/**   
* @Title: Caculator.java 
* @Package com.test.airwallex.rpncaculator 
* @Description: Define the basic functions of Caculator 
* @author Xie Forest   
* @date Nov 27, 2018 1:01:42 PM 
* @version V1.0   
*/
package com.test.job.caculator;

/**
 * @author Xie Forest
 *
 */
public interface Caculator {
	
	/**
	 *  check expression except undo
	 * @param expression
	 * @throws RPNException 
	 */
	 void evaluate(String expression) throws RPNException;
	 
	 /**
	  * if the current operation is undo, update the expression
	  * @param expression
	  * @param isUndo
	 * @throws RPNException 
	  */
	 void evaluate(String expression, boolean isUndo) throws RPNException;
	 
	 /**
	  * Check the token, judge if it is a digit or an operator
	  * @param token
	  * @param isUndo
	 * @throws RPNException 
	  */
	 void processToken(String token, boolean isUndo) throws RPNException;
	 
	 /**
	  * execute the operation and update the stack
	  * @param operator
	  * @param isUndo
	 * @throws RPNException 
	  */
	 void executeOperator(String operator, boolean isUndo) throws RPNException;

}
