package problem001_010;
/**
 * Problem7.java 
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
public class Problem7 {

	public static void main(String[] args) {
		int numPrimes = 0;
		int thisPrime = 0;
		int increment = 0;
		while (numPrimes < 10001) {
			increment++;
			if (checkPrime(increment)) {
				numPrimes++;
				thisPrime = increment;
			}
		}
		System.out.println(thisPrime + "");
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
