package com.test.job.operator;

import com.test.job.caculator.RPNException;

public abstract class Operator {
	
	  	private String symbol;
	    private String opposite;
	    private int numOfOperand;

	    Operator(String symbol, String opposite, int operandsNumber) {
	        this.symbol = symbol;
	        this.opposite = opposite;
	        this.numOfOperand = operandsNumber;
	    }

	    public abstract Double calculate(Double firstOperand, Double secondOperand) throws RPNException;

	    public String getSymbol() {
	        return symbol;
	    }

	    public String getOpposite() {
	        return opposite;
	    }

	    public int getOperandsNumber() {
	        return numOfOperand;
	    }

}
