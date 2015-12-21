package problem061_070;

import euler.util.DigitCounter;

/**
 * Problem70.java 
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
public class Problem70 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 0;
		double maxRatio = 0;
		for (int i = 1; i < 10000000; i++) {
			int t = fi(i);

			double ratio = (double) i / (double) t;
			if (ratio > maxRatio) {
				if (check(i, t)) {
					System.out.println("new max: " + i + ", " + t + ", " + ratio);
					maxRatio = ratio;
					max = i;
				}
			}

		}

	}

	public static boolean check(int n, int t) {
		int[] np = DigitCounter.pattern(n);
		int[] tp = DigitCounter.pattern(t);

		for (int i = 0; i < tp.length; i++) {
			if (!(np[i] == tp[i])) {
				return false;
			}
		}
		return true;
	}

	public static int fi(int n) {
		int result = n;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				result -= result / i;
			while (n % i == 0)
				n /= i;
		}
		if (n > 1)
			result -= result / n;
		return result;
	}
}
