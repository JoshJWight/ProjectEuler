package problem051_060;

import euler.util.DigitCounter;

/**
 * Problem52.java 
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
public class Problem52 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i < 1000000000; i++) {
			System.out.print("checking " + i + ": ");
			if (check(i)) {
				System.out.print("found " + i);
			}
		}

	}

	public static boolean check(int num) {
		int[] pattern = DigitCounter.pattern(2 * num);
		for (int i = 3; i <= 6; i++) {
			if (!DigitCounter.pattern(num * i).equals(pattern)) {
				System.out.println("failed at " + i);
				return false;
			}
		}
		System.out.println("succeeded");
		return true;
	}

}
