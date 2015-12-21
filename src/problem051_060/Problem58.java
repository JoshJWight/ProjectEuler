package problem051_060;

import euler.util.PrimeChecker;

/**
 * Problem58.java 
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
public class Problem58 {

	public static void main(String[] args) {
		int inc = 1;
		int len = 1;
		int primes = 0;
		int nums = 1;
		while (true) {
			len += 2;
			for (int i = 0; i < 4; i++) {
				nums++;
				inc += len - 1;
				if (PrimeChecker.check(inc)) {
					primes++;
				}
			}
			if ((double) primes / (double) nums < .1) {
				System.out.println(len + "");
				break;
			}
		}

	}

}
