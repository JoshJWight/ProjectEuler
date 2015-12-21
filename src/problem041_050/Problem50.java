package problem041_050;

import java.util.ArrayList;

import euler.util.PrimeChecker;

/**
 * Problem50.java 
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
public class Problem50 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < 1000000; i++) {
			if (PrimeChecker.check(i)) {
				primes.add(i);
			}
		}
		int maxLength = 1;
		for (int i = 0; i < primes.size(); i++) {
			for (int j = maxLength + 1; j <= primes.size() - i; j++) {
				int sum = 0;
				for (int k = i; k < i + j; k++) {
					sum += primes.get(k);
				}
				if (sum >= 1000000) {
					break;
				}
				if (PrimeChecker.check(sum)) {
					maxLength = j;
					System.out.println("found (" + i + ", " + j + ", " + sum);
				}
			}
		}

	}

}
