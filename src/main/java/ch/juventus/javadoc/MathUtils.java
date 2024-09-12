package ch.juventus.javadoc;

import java.util.List;

/**
 * The MathUtils class implements methods to add, subtract, divide and multiply numbers.
 *
 * @author Linda Krüger
 * @version 1.0
 */
public class MathUtils {

    /**
     * This method adds all the given numbers to a total.
     * If the input list is empty, 0 will be returned.
     * If the input list is null, a NullPointerException will be thrown.
     *
     * @param numbers The list of numbers to add together
     * @return The sum of all the given numbers
     * @throws NullPointerException Thrown if the input list is null
     */
    public double addition(List<Double> numbers) {
        double result = 0;
        for (Double number : numbers) {
            result += number;
        }
        return result;
    }

    /**
     * This method subtracts the second number from the first and returns the result.
     * Params can not be null.
     * @param a The number to subtract from
     * @param b The number to subtract
     * @return The result of the subtraction
     */
    public double subtraction(double a, double b) {
        return a - b;
    }

    /**
     * This method divides the first number by the second and returns the result.
     * Params can not be null.
     * @param a The number to divide
     * @param b The number to divide by
     * @return The result of the division
     */
    public double division(double a, double b) {
        return a / b;
    }

    /**
     * This method multiplies the first number by the second and returns the result.
     * Params can not be null.
     * @param a The number to multiply
     * @param b The number to multiply by
     * @return The result of the multiplication
     */
    public double multiplication(double a, double b) {
        return a * b;
    }

}