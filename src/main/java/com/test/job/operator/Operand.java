/**   
* @Title: Operand.java 
* @Package com.test.airwallex.operator 
* @Description: Used to record the operation
* @author Xie Forest   
* @date Nov 27, 2018 2:51:34 PM 
* @version V1.0   
*/
package com.test.job.operator;

import com.test.job.caculator.RPNException;

/**
 * @author Xie Forest
 *
 */

public class Operand {
	
	 	Operator operator;
	    Double value;
	    boolean zeroUndo = false;

	    public Operand(Operator operator, Double value) {
	        this.operator = operator;
	        this.value = value;
	    }
	    
	    public Operand(Operator operator, Double value, boolean zeroUndo) {
	        this.operator = operator;
	        this.value = value;
	        this.zeroUndo = zeroUndo;
	    }

	    public String getReverseOperand() throws RPNException {
	        if (operator.getOperandsNumber() < 1)
	            throw new RPNException(String.format("Invalid operation for operator %s", operator.getSymbol()));
	        else if(operator.getOperandsNumber() < 2)
	        		return String.format("%s", operator.getOpposite());
	        else
	        		return String.format("%f %s %f", value, operator.getOpposite(), value);
	    }
	    
	    public boolean isZeroUndo()
	    {
	    		return zeroUndo;
	    }
	    
	    public Operator getOperator()
	    {
	    		return operator;
	    }
	    
	    public Double getValue()
	    {
	    		return value;
	    }
	    
	    
	    

}
