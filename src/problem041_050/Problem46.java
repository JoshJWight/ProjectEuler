package problem041_050;

import euler.util.PrimeChecker;

/**
 * Problem46.java 
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
public class Problem46 {

	public static void main(String[] args) {
		for (int i = 3; i < 99999999; i += 2) {
			for (int j = 3; j <= i; j += 2) {
				int k = j * i;
				if (!check(k)) {
					System.out.println(k + "");
					return;
				}
			}
		}

	}

	public static boolean check(int num) {
		for (int i = 0; i < (Math.sqrt(num / 2) + 1); i++) {
			int j = num - (i * i * 2);
			if (PrimeChecker.check(j)) {
				return true;
			}
		}
		return false;
	}

}
