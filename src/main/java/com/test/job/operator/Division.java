/**   
* @Title: Division.java 
* @Package com.test.airwallex.operator 
* @Description: Division Implementation 
* @author Xie Forest   
* @date Nov 27, 2018 8:45:25 PM 
* @version V1.0   
*/
package com.test.job.operator;

import com.test.job.caculator.RPNException;

/**
 * @author Xie Forest
 *
 */
public class Division extends Operator {

	public Division(String symbol, String opposite, int operandsNumber) {
		super(symbol, opposite, operandsNumber);
	}

	@Override
	public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
        if (firstOperand == 0)
            throw new RPNException("0 can not be divided!!!");
        return secondOperand / firstOperand;	}

}
