package problem001_010;
/**
 * Problem3.java 
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
public class Problem3 {
	public static void main(String[] args) {
		double num = 600851475143.0;
		double max = 0;
		for (double a = 0; a < Math.sqrt(num); a++) {
			if (checkFactor(num, a) && checkPrime(a)) {
				max = num / a;
				System.out.println("600851475143 = " + num + " x " + a);
			}
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
		for (double a = 2; a <= Math.sqrt(num); a++) {
			if (checkFactor(num, a)) {
				return false;
			}
		}
		return true;
	}
}
