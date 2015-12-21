package problem031_040;

import euler.util.PrimeChecker;

/**
 * Problem37.java 
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
public class Problem37 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 10; i < 1000000; i++) {
			if (checkLTR(i) && checkRTL(i)) {
				sum += i;
				System.out.println("found " + i);
			}
		}
		System.out.println("" + sum);

	}

	public static boolean checkLTR(int num) {
		int numDigits = 1 + (int) Math.log10(num);
		int n = num;
		while (numDigits > 0) {
			if (!PrimeChecker.check(n)) {
				return false;
			}
			n = n % (int) (Math.pow(10, numDigits - 1));
			numDigits--;
		}
		return true;

	}

	public static boolean checkRTL(int num) {
		int numDigits = 1 + (int) Math.log10(num);
		int n = num;
		while (numDigits > 0) {
			if (!PrimeChecker.check(n)) {
				return false;
			}
			n = n / 10;
			numDigits--;
		}
		return true;

	}

}
