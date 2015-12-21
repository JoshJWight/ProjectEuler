package problem051_060;

import euler.util.LargeInt;

/**
 * Problem56.java 
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
public class Problem56 {

	public static void main(String[] args) {
		int max = 0;
		for (int a = 1; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				int s = sum(a, b);
				if (s > max) {
					max = s;
				}
			}
		}
		System.out.println(max + "");

	}

	public static int sum(int num, int exp) {
		LargeInt i = new LargeInt(1);
		for (int j = 0; j < exp; j++) {
			i.mult(num);
		}

		int sum = 0;
		for (int j : i.digits) {
			sum += j;
		}
		return sum;
	}

}
