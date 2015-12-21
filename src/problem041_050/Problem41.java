package problem041_050;

import euler.util.DigitCounter;
import euler.util.PrimeChecker;

/**
 * Problem41.java 
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
public class Problem41 {

	public static void main(String[] args) {
		for (int i = 2; i < 1000000000; i++) {
			if (check(i)) {
				System.out.println("" + i);
			}
		}

	}

	public static boolean check(int i) {
		int numDigits = DigitCounter.count(i);
		int[] digits = DigitCounter.digits(i);
		for (int j = 1; j <= numDigits; j++) {
			boolean found = false;
			for (int k = 0; k < numDigits; k++) {
				if (digits[k] == j) {
					found = true;
				}
			}
			if (!found) {
				return false;
			}
		}
		if (PrimeChecker.check(i)) {
			return true;
		}
		return false;
	}

}
