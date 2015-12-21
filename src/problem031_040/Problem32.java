package problem031_040;

import euler.util.DigitCounter;
import euler.util.FactorChecker;

/**
 * Problem32.java 
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
public class Problem32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 100; i < 100000; i++) {
			if (check(i)) {
				sum += i;
			}
		}
		System.out.println("" + sum);

	}

	public static boolean check(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (FactorChecker.check(num, i)) {
				if (pandigital(num, i, num / i)) {
					System.out.println("Found " + i + " x " + num / i + " = " + num);
					return true;
				}
			}
		}
		return false;
	}

	public static boolean pandigital(int a, int b, int c) {
		int[] record = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		int[] aDigits = DigitCounter.digits(a);
		int[] bDigits = DigitCounter.digits(b);
		int[] cDigits = DigitCounter.digits(c);

		for (int i : aDigits) {
			if (i == 0 || record[i - 1] == 1) {
				return false;
			}
			record[i - 1] = 1;
		}
		for (int i : bDigits) {
			if (i == 0 || record[i - 1] == 1) {
				return false;
			}
			record[i - 1] = 1;
		}
		for (int i : cDigits) {
			if (i == 0 || record[i - 1] == 1) {
				return false;
			}
			record[i - 1] = 1;
		}
		for (int i : record) {
			if (i == 0) {
				return false;
			}
		}
		return true;
	}

}
