package euler.util;
/**
 * FactorChecker.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * @author Josh Wight
 *
 */
public class FactorChecker {
	public static boolean check(int big, int small) {
		double result = (double) big / (double) small;
		return (double) (int) result == result;

	}

	public static boolean check(double big, int small) {
		double result = big / small;
		result = result % 1;
		return result == 0;
	}
}
