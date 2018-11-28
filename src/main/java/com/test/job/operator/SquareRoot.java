/**   
* @Title: Squar.java 
* @Package com.test.airwallex.operator 
* @Description: Square implementation 
* @author Xie Forest   
* @date Nov 27, 2018 8:48:14 PM 
* @version V1.0   
*/
package com.test.job.operator;

import static java.lang.Math.sqrt;

import com.test.job.caculator.RPNException;

/**
 * @author Xie Forest
 *
 */
public class SquareRoot extends Operator {

	public SquareRoot(String symbol, String opposite, int operandsNumber) {
		super(symbol, opposite, operandsNumber);
	}

	@Override
	public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
        return sqrt(firstOperand);
	}

}
