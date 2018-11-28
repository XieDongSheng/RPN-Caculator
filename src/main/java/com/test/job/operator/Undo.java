/**   
* @Title: Undo.java 
* @Package com.test.airwallex.operator 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Xie Forest   
* @date Nov 27, 2018 8:54:12 PM 
* @version V1.0   
*/
package com.test.job.operator;

import com.test.job.caculator.RPNException;

/**
 * @author Xie Forest
 *
 */
public class Undo extends Operator {

	public Undo(String symbol, String opposite, int operandsNumber) {
		super(symbol, opposite, operandsNumber);
	}

	@Override
	public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
		return null;
	}

}
