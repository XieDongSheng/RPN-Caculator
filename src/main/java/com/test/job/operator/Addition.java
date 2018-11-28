/**   
* @Title: ADDITION.java 
* @Package com.test.airwallex.operator 
* @Description: ADDITION 
* @author Xie Forest   
* @date Nov 27, 2018 2:41:55 PM 
* @version V1.0   
*/
package com.test.job.operator;

import com.test.job.caculator.RPNException;

/**
 * @author Xie Forest
 *
 */
public class Addition extends Operator {

	public Addition(String symbol, String opposite, int operandsNumber) {
		super(symbol, opposite, operandsNumber);
	}

	@Override
	public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
        return secondOperand + firstOperand;
	}

}
