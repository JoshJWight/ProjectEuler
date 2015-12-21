package problem021_030;
/**
 * Problem27.java 
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
public class Problem27 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxA = 0;
		int maxB = 0;
		int maxPrimes = 0;
		for (int a = -999; a < 1000; a++) {
			System.out.println("Starting cycle for a=" + a);
			for (int b = -999; b < 1000; b++) {
				int primes = primes(a, b);
				if (primes > maxPrimes) {
					maxPrimes = primes;
					maxA = a;
					maxB = b;
				}
			}
		}
		System.out.println(maxA + " * " + maxB + " = " + (maxA * maxB));

	}

	public static int primes(int a, int b) {
		int primes = 0;

		int n = 0;
		while (true) {
			int num = n * n + a * n + b;
			if (checkPrime(num)) {
				primes++;
			} else {
				return primes;
			}
			n++;
		}
	}

	public static boolean checkFactor(double big, double small) {
		double result = big / small;
		if ((double) (int) result == result) {
			return true;
		}
		return false;
	}

	public static boolean checkPrime(double num) {
		if (num <= 1) {
			return false;
		}
		for (double a = 2; a <= Math.sqrt(num); a++) {
			if (checkFactor(num, a)) {
				return false;
			}
		}
		return true;
	}

}
