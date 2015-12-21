package problem061_070;

import java.util.ArrayList;

import euler.util.FactorChecker;
import euler.util.PrimeChecker;

/**
 * Problem69.java 
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
public class Problem69 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 0;
		double maxRatio = 0;

		for (int i = 2; i <= 1000000; i++) {
			int f = factors(i);
			/*
			 * if(f<60) { continue; }
			 */
			// System.out.println(i + "");
			int phi = fi(i);
			double ratio = (double) i / (double) phi;
			System.out.println(i + ", " + phi + ", " + ratio + ". " + f + " factors");

			if (ratio > maxRatio) {
				System.out.println("New max: " + i + ", " + phi + ", " + ratio + ". " + f + " factors");
				max = i;
				maxRatio = ratio;
			}
		}
		System.out.println("" + max);

	}

	public static int phi(int i) {
		int maxk = (int) Math.sqrt(i) + 1;
		int phi = 1;
		for (int j = 2; j < i; j++) {
			if (FactorChecker.check(i, j)) {
				continue;
			}

			for (int k = 2; k <= maxk; k++) {
				if (FactorChecker.check(j, k) && FactorChecker.check(i, k)) {
					break;
				}
				if (k > j || k == maxk) {
					phi++;
					break;
				}
			}
		}
		return phi;
	}

	public static int factors(int i) {
		int factors = 0;
		for (int j = 2; j <= (int) Math.sqrt(i) + 1; j++) {
			if (FactorChecker.check(i, j)) {
				factors++;
			}
		}
		return factors;
	}

	public static int phi2(int i) {
		int phi = i - 1;

		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int j = 2; j <= (int) Math.sqrt(i) + 1; j++) {
			if (FactorChecker.check(i, j)) {
				if (PrimeChecker.check(j)) {
					factors.add(j);
				}
			}
		}

		if (factors.size() > 0) // the number isn't prime
		{
			for (int j = 0; j < factors.size(); j++) {
				int f = factors.get(j);
				int n = (i - 1) / f;
				int nf = n;
				for (int k = 0; k < j; k++) {
					int f2 = factors.get(k);
					int ns = n / f2;

				}

			}
		}

		return phi;
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
