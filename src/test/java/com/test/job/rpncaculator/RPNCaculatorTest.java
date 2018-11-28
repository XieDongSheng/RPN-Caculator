package com.test.job.rpncaculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.test.job.caculator.RPNException;
import com.test.job.caculator.RPNCaculator;


public class RPNCaculatorTest
{
	
    RPNCaculator calculator = new RPNCaculator();

    @Test
	public void testOperators() throws RPNException {
    /**
     * Example 1
     */
    calculator.evaluate("5 2");
    assertEquals(5, calculator.getNumberStack().get(0), 0);
    calculator.evaluate("clear");

    
    /**
     * Example 2
     */
    calculator.evaluate("2 sqrt");
    assertEquals(1, calculator.getNumberStack().size());
    calculator.evaluate("clear 9 sqrt");
    assertEquals(1, calculator.getNumberStack().size());

    /**
     * Example 3
     */
    calculator.evaluate("clear");
    calculator.evaluate("5 2 -");
    assertEquals(1, calculator.getNumberStack().size());
    calculator.evaluate("3 -");
    assertEquals(1, calculator.getNumberStack().size());

    calculator.evaluate("clear");

    /**
     * Example 4
     */
    calculator.evaluate("5 4 3 2");
    assertEquals(4, calculator.getNumberStack().size());
    calculator.evaluate("undo undo *");
    assertEquals(1, calculator.getNumberStack().size());
    calculator.evaluate("5 *");
    assertEquals(100, calculator.getNumberStack().get(0),0);
    calculator.evaluate("undo");
    assertEquals(2, calculator.getNumberStack().size());


    /**
     * Example 5
     */
    calculator.evaluate("clear");
    calculator.evaluate("7 12 2 /");
    assertEquals(7, calculator.getNumberStackItem(0), 0);
    assertEquals(6, calculator.getNumberStackItem(1), 0);
    calculator.evaluate("*");
   assertEquals(1, calculator.getNumberStack().size());
   assertEquals(42, calculator.getNumberStackItem(0), 0);
    calculator.evaluate("4 /");
   assertEquals(1, calculator.getNumberStack().size());
   assertEquals(10.5, calculator.getNumberStackItem(0), 1);

    /**
     * Example 6
     */
    calculator.evaluate("clear");
    calculator.evaluate("1 2 3 4 5 *");
   assertEquals(4, calculator.getNumberStack().size());
    calculator.evaluate("clear 3 4 -");
   assertEquals(1, calculator.getNumberStack().size());
   assertEquals(-1, calculator.getNumberStackItem(0), 0);

    
    /**
     * Example 7
     */
    calculator.evaluate("clear");
    calculator.evaluate("1 2 3 4 5");
    calculator.evaluate("* * * *");
   assertEquals(1, calculator.getNumberStack().size());
   assertEquals(120, calculator.getNumberStackItem(0), 0);


    /**
     * Example 8
     */
    calculator.evaluate("clear");
    try {
        calculator.evaluate("1 2 3 * 5 + * * 6 5");
    } catch (RPNException e) {
    	assertEquals("operator * (position: 8): insufficient parameters", e.getMessage());
    }
   assertEquals(1, calculator.getNumberStack().size());
   assertEquals(11, calculator.getNumberStackItem(0), 0);
}



}
