package problem051_060;

import java.util.ArrayList;

import euler.util.DigitCounter;
import euler.util.PrimeChecker;

/**
 * Problem60.java 
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
public class Problem60 {

	private static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {

		int inc = 1;
		while (primes.size() < 5000) {
			if (PrimeChecker.check(inc)) {
				primes.add(inc);
			}
			inc++;
		}

		int min = Integer.MAX_VALUE;
		for (int a = 0; a < primes.size(); a++) {
			// System.out.println("a = " + a + "(" + primes.get(a) + ")");
			for (int b = a + 1; b < primes.size(); b++) {
				// System.out.println("b = " + b);
				if (!check(primes.get(a), primes.get(b))) {
					continue;
				}
				// System.out.println("b found: " + primes.get(a) + ", " +
				// primes.get(b));
				for (int c = b + 1; c < primes.size(); c++) {
					if (!check(primes.get(a), primes.get(c)) || !check(primes.get(b), primes.get(c))) {
						continue;
					}
					// System.out.println("c found: " + primes.get(a) + ", " +
					// primes.get(b) + ", " + primes.get(c));
					for (int d = c + 1; d < primes.size(); d++) {
						if (!check(primes.get(a), primes.get(d)) || !check(primes.get(b), primes.get(d))
								|| !check(primes.get(c), primes.get(d))) {
							continue;
						}
						// System.out.println("d found: " + primes.get(a) + ", "
						// + primes.get(b) + ", " + primes.get(c) + ", " +
						// primes.get(d));
						for (int e = d + 1; e < primes.size(); e++) {
							if (!check(primes.get(a), primes.get(e)) || !check(primes.get(b), primes.get(e))
									|| !check(primes.get(c), primes.get(e)) || !check(primes.get(d), primes.get(e))) {
								continue;
							} else {
								System.out.println("e found: " + primes.get(a) + ", " + primes.get(b) + ", "
										+ primes.get(c) + ", " + primes.get(d) + ", " + primes.get(e));
								int total = primes.get(a) + primes.get(b) + primes.get(c) + primes.get(d)
										+ primes.get(e);
								if (total < min) {
									min = total;
									System.out.println(
											"found (" + primes.get(a) + " + " + primes.get(b) + " + " + primes.get(c)
													+ " + " + primes.get(d) + " + " + primes.get(e) + ") = " + total);
								}
							}
						}
					}
				}
			}
		}

	}

	public static boolean check(int a, int b) {
		int as = DigitCounter.count(a);
		int bs = DigitCounter.count(b);

		int t1 = a + (int) (Math.pow(10, as) * b);
		int t2 = b + (int) (Math.pow(10, bs) * a);

		if (!PrimeChecker.check(t1) || !PrimeChecker.check(t2)) {
			return false;
		}
		return true;
	}

	public static boolean check(int[] set) {
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (!check(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

}
