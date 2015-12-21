package euler.util;
/**
 * PrimeChecker.java 
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
public class PrimeChecker {
	// return true if num is prime
	public static boolean check(int num) {
		if (num <= 1) {
			return false;
		}
		for (double a = 2; a <= Math.sqrt(num); a++) {
			if (num % a == 0) {
				return false;
			}
		}
		return true;
	}
}
