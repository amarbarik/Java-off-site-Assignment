package za.co.discovery.assignment.fibonacci;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Amar on 2015/08/31.
 * This is used to find out the even fibonacci series and their sum
 * Ts & Cs: Value should not exceed 4 million
 */
public class EvenFibonacciSeries {

    private static Logger logger = Logger.getLogger(EvenFibonacciSeries.class);
    private static final long maxValue = 4 * Math.round(Math.pow(10, 6));

    /**
     * Prints the series using recursion
     *
     * @param evenFibonacci ArrayList containing the evenFibonacci Series
     * @param initialValue  Initial Value of the series
     * @param sum           Holds the result of the SUM
     */
    public static void printValueUsingRecursion(List<Integer> evenFibonacci, int initialValue, long sum) {
        logger.info("Fibonacci series up to " + maxValue + " numbers (Using Recursion): ");
        int currentValue;
        do {
            currentValue = usingRecursion(initialValue);
            if (currentValue % 2 == 0) evenFibonacci.add(currentValue);
            System.out.print(currentValue + ", ");
            initialValue++;
        } while (currentValue <= maxValue);

        System.out.println("\n\nEven Valued Fibonacci: " + evenFibonacci.toString());
        System.out.print("\nSum of even valued fibonacci: ");

        for (Integer anEvenFibonacci : evenFibonacci) {
            sum += anEvenFibonacci;
        }
        System.out.println(sum);
    }

    /**
     * Recursive method to be called for Fibonacci
     *
     * @param number the next sequence
     */
    private static int usingRecursion(int number) {
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        return usingRecursion(number - 1) + usingRecursion(number - 2);
    }

    /**
     * Prints the series using loop
     *
     * @param evenFibonacci ArrayList containing the evenFibonacci Series
     * @param initialValue  Initial Value of the series
     * @param sum           Holds the result of the SUM
     */
    public static void printValueUsingLoop(List<Integer> evenFibonacci, int initialValue, long sum) {
        logger.info("Fibonacci series up to " + maxValue + " numbers (Using Loop): ");
        int currentValue = 1;
        for (initialValue = 1; currentValue <= maxValue; initialValue++) {
            currentValue = usingLoop(initialValue);
            if (currentValue % 2 == 0) evenFibonacci.add(currentValue);
            System.out.print(currentValue + ", ");
        }
        System.out.println("\n\nEven Valued Fibonacci: " + evenFibonacci.toString());
        System.out.print("\nSum of even valued fibonacci: ");

        for (Integer anEvenFibonacci : evenFibonacci) {
            sum += anEvenFibonacci;
        }
        System.out.println(sum);
    }

    /**
     * Method to be called for Fibonacci Series using Loop
     *
     * @param number the next sequence
     */
    private static int usingLoop(int number) {
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        int fibo1 = 1, fibo2 = 2, fibonacci = 1;
        for (int i = 3; i <= number; i++) {
            fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci number
            fibo1 = fibo2;
            fibo2 = fibonacci;

        }
        return fibonacci; //Fibonacci number
    }
}
