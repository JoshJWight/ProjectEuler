package problem031_040;

import euler.util.DigitCounter;

/**
 * Problem40.java 
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
public class Problem40 {

	public static void main(String[] args) {
		int[] factors = new int[7];
		int next = 1;
		int nextIndex = 0;
		int inc = 0;

		for (int i = 1; i < 1000000; i++) {
			int numDigits = DigitCounter.count(i);
			if (inc + numDigits >= next) {
				int pos = numDigits - 1 - (next - inc - 1);
				int[] digits = DigitCounter.digits(i);

				factors[nextIndex] = digits[pos];

				next *= 10;
				nextIndex++;
				if (next > 1000000) {
					break;
				}
			}
			inc += numDigits;
		}

		int prod = 1;
		for (int i = 0; i <= 6; i++) {
			System.out.print(factors[i] + " * ");
			prod *= factors[i];
		}
		System.out.println(" = " + prod);
	}

}
