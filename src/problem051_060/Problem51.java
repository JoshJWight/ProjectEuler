package problem051_060;

import euler.util.DigitCounter;
import euler.util.PrimeChecker;

/**
 * Problem51.java 
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
public class Problem51 {

	public static void main(String[] args) {
		for (int i = 10000; i < 1000000; i++) {

			if (PrimeChecker.check(i)) {
				System.out.println("checking " + i);
				if (check(i)) {
					break;
				}
			}

		}

	}

	public static boolean check(int num) {
		int[] digits = DigitCounter.digits(num);
		int[] schema = new int[digits.length];
		for (int i = 0; i < schema.length; i++) {
			schema[i] = 0;
		}
		schema[0] = 1;

		while (schema != null) {
			int[] testDigits = digits.clone();
			int primes = 0;
			int i = 0;
			if (schema[schema.length - 1] == 1) {
				i = 1;
			}
			for (; i < 10; i++) {
				for (int j = 0; j < schema.length; j++) {
					if (schema[j] == 1) {
						testDigits[j] = i;
					}
				}
				if (PrimeChecker.check(DigitCounter.num(testDigits))) {
					primes++;
				}
			}
			if (primes == 8) {
				System.out.println("found " + num + " with schema " + DigitCounter.num(schema));
				return true;
			}

			schema = nextSchema(schema);
		}
		return false;

	}

	public static int[] nextSchema(int[] schema) {
		int i = 0;
		while (true) {
			if (i >= schema.length) {
				return null;
			} else if (schema[i] == 0) {
				schema[i] = 1;
				return schema;
			} else {
				schema[i] = 0;
				i++;
			}
		}
	}

}
