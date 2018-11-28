package com.test.job.executor;

import java.util.HashMap;
import java.util.Map;

import com.test.job.operator.Addition;
import com.test.job.operator.Clear;
import com.test.job.operator.Division;
import com.test.job.operator.Multiplication;
import com.test.job.operator.Operator;
import com.test.job.operator.Pow;
import com.test.job.operator.SquareRoot;
import com.test.job.operator.Subtraction;
import com.test.job.operator.Undo;


public class Context {
	
    public static final Map<String, Operator> OPERATOR_MAP = new HashMap<String, Operator>();
    
    public static Operator getOperator(String value) {
        return OPERATOR_MAP.get(value);
    }
    
    static  {
    		OPERATOR_MAP.put("+", new Addition("+", "-", 2));
    		OPERATOR_MAP.put("-", new Subtraction("-", "+", 2));
    		OPERATOR_MAP.put("*", new Multiplication("*", "/", 2));
    		OPERATOR_MAP.put("/", new Division("/", "*", 2));
    		OPERATOR_MAP.put("sqrt", new SquareRoot("sqrt", "pow", 1));
    		OPERATOR_MAP.put("pow", new Pow("pow", "sqrt", 1));
    		OPERATOR_MAP.put("clear", new Undo("clear", "null", 0));
    		OPERATOR_MAP.put("undo", new Clear("undo", "null", 0));
    }

}
