package com.test.job.executor;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.Stack;

import com.test.job.caculator.RPNCaculator;
import com.test.job.caculator.RPNException;

public class Executor {

    private static String QUIT ="quit";


    public static void main(String[] args) {

        Console console = System.console();
        boolean isRunning = true;
        
        if (console == null) {
            System.err.println("Please check if the program is executed in console!");
            System.exit(1);
        }

        RPNCaculator calculator = new RPNCaculator();

        System.out.println("Enter your expression, or 'quit' to leave");

        while (isRunning) {
        	
            String expression = console.readLine(": ");
            
            if (QUIT.equals(expression)) {
            		isRunning = false;
            		
            } else {
                try {
                    calculator.evaluate(expression);
                } catch (RPNException e) {
                    System.out.println(e.getMessage());
                }
                
                Stack<Double> stack = calculator.getNumberStack();
                DecimalFormat df = new DecimalFormat("0.#####");

                System.out.print("Stack: ");
                for (Double num : stack) {
                    System.out.print(df.format(num));
                    System.out.print(" ");
                }
                System.out.printf("%n");
            }
        }
    }
}
