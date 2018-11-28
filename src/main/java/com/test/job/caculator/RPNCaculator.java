/**   
* @Title: RPNCaculator.java 
* @Package com.test.airwallex.caculator 
* @Description: The RPN caculator implementation
* @author Xie Forest   
* @date Nov 27, 2018 2:27:47 PM 
* @version V1.0   
*/
package com.test.job.caculator;

import java.util.Stack;

import com.test.job.executor.Context;
import com.test.job.operator.Operand;
import com.test.job.operator.Operator;

/**
 * @author Xie Forest
 *
 */
public class RPNCaculator implements Caculator {

    private Stack<Double> numberStack = new Stack<Double>();
    private Stack<Operand> operandStack = new Stack<Operand>();
    private Operand  NO_OPERAND = null;
    private int currentIndex = 0;
    private static String CLEAR = "clear";
    private static String UNDO = "undo";


    private Double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public Stack<Double> getNumberStack() {
        return numberStack;
    }
    
    public Double getNumberStackItem(int index) {
    		return numberStack.get(index);
    }
    
    public Stack<Operand> getOperndStack() {
    		return operandStack;
    }
     
	public void evaluate(String expression) throws RPNException {
		evaluate(expression, false);		
	}

	public void evaluate(String expression, boolean isUndo) throws RPNException {
		 if (expression == null || expression.length() == 0) {
	            throw new RPNException("Input cannot be null.");
	        }
	        currentIndex = 0;
	        String[] result = expression.split("\\s");
	        for (String tokenString : result) {
	            currentIndex++;
	            processToken(tokenString, isUndo);
	        }		
	}

	public void processToken(String token, boolean isUndo) throws RPNException {
		
		//Check it is a digit
        Double value = parseDouble(token);
        
        if (value == null) {
        	   executeOperator(token, isUndo);
        } else {
            numberStack.push(Double.parseDouble(token));
            if (!isUndo) {
            	//Used for undo
            	operandStack.push(NO_OPERAND);
            }
        }		
	}

	public void executeOperator(String operatorString, boolean isUndo) throws RPNException {

        if (numberStack.isEmpty()) {
            throw new RPNException("Number stack is empty!!!");
        }

        Operator operator = Context.getOperator(operatorString);
        if (operator == null) {
            throw new RPNException("Operator is invalid!!!");
        }

        if (operatorString.equals(RPNCaculator.CLEAR)) {
            clearStacks();
            return;
        }

        if (operatorString.equals(RPNCaculator.UNDO)) {
            undoOperand();
            return;
        }

        if (operator.getOperandsNumber() > numberStack.size()) {
            throwInvalidOperand(operatorString);
        }

        Double firstOperand = numberStack.pop();
        Double secondOperand = (operator.getOperandsNumber() > 1) ? numberStack.pop() : null;
        
        Double result = operator.calculate(firstOperand, secondOperand);

        if (result != null) {
            numberStack.push(result);
            if (!isUndo) {
            	operandStack.push(new Operand(Context.getOperator(operatorString), firstOperand));
            }
        }		
	}
	
	
    private void undoOperand() throws RPNException {
        if (operandStack.isEmpty()) {
            throw new RPNException("no operations to undo");
        }

        Operand lastOperand = operandStack.pop();
        if (lastOperand == NO_OPERAND) {
            numberStack.pop();
        } else {
        		evaluate(lastOperand.getReverseInstruction(), true);
        }
    }

    private void clearStacks() {
        numberStack.clear();
        operandStack.clear();
    }

    private void throwInvalidOperand(String operator) throws RPNException {
        throw new RPNException(
                String.format("operator %s (position: %d): insufficient parameters", operator, currentIndex));
    }


}
