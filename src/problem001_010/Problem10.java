package problem001_010;
/**
 * Problem10.java 
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
public class Problem10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;
		for (int a = 0; a < 2000000; a++) {
			if (checkPrime(a)) {
				sum += a;
			}
		}
		System.out.println(sum + "");

	}

	public static boolean checkPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int a = 2; a <= Math.sqrt(num); a++) {
			if (num % a == 0) {
				return false;
			}
		}
		return true;
	}
}
