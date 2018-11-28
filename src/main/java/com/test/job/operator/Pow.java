/**   
* @Title: pow.java 
* @Package com.test.airwallex.operator 
* @Description: Pow 
* @author Xie Forest   
* @date Nov 27, 2018 8:53:06 PM 
* @version V1.0   
*/
package com.test.job.operator;

import static java.lang.Math.pow;

import com.test.job.caculator.RPNException;

/**
 * @author Xie Forest
 *
 */
public class Pow extends Operator {

	public Pow(String symbol, String opposite, int operandsNumber) {
		super(symbol, opposite, operandsNumber);
	}

	@Override
	public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
        return pow(firstOperand, 2.0);
	}

}
