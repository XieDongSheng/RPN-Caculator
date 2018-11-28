/**   
* @Title: Multiplication.java 
* @Package com.test.airwallex.operator 
* @Description: Multiplication implementation 
* @author Xie Forest   
* @date Nov 27, 2018 8:42:48 PM 
* @version V1.0   
*/
package com.test.job.operator;

import com.test.job.caculator.RPNException;

/**
 * @author Xie Forest
 *
 */
public class Multiplication extends Operator {

	public Multiplication(String symbol, String opposite, int operandsNumber) {
		super(symbol, opposite, operandsNumber);
	}

	@Override
	public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
		
        return secondOperand * firstOperand;
	}

}
