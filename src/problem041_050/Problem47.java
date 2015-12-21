package problem041_050;

import euler.util.FactorChecker;

/**
 * Problem47.java 
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
public class Problem47 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 4;
		int prev = 1;
		int prev2 = 1;
		int prev3 = 0;
		while (true) {
			int factors = factors(i);
			System.out.println(i + ": " + factors + " factors");
			if (factors == 4 && prev == 4 && prev2 == 4 && prev3 == 4) {
				System.out.println((i - 3) + "");
				break;
			}
			prev3 = prev2;
			prev2 = prev;
			prev = factors;
			i++;
		}

	}

	public static int factors(int num) {
		int j = num;
		int factors = 0;
		for (int i = 2; i <= j; i++) {
			boolean found = false;
			while (FactorChecker.check(j, i)) {
				found = true;
				j = j / i;
			}
			if (found) {
				factors++;
			}
		}
		return factors;
	}

}
