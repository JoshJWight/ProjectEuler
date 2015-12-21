package problem051_060;

import euler.util.LargeInt;

/**
 * Problem55.java 
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
public class Problem55 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int total = 0;
		for (int i = 1; i < 10000; i++) {
			if (check(i)) {
				System.out.println("found " + i);
				total++;
			}
		}
		System.out.println("" + total);

	}

	public static boolean check(int num) {
		LargeInt i = new LargeInt(num);
		int iterations = 0;
		while (iterations < 50) {
			iterations++;
			i.add(i.reverse());
			if (i.isPalindromic()) {
				// System.out.println(num + " is not lychrel - " + iterations +
				// " iterations.");
				return false;
			}

		}
		return true;
	}

}
