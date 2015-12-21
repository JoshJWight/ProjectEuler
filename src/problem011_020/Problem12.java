package problem011_020;
/**
 * Problem12.java 
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
public class Problem12 {
	public static void main(String[] args) {

		int sum = 1;
		int inc = 2;
		while (factors(sum) <= 500) {
			sum += inc;
			inc++;
		}
		System.out.println(sum + "");
	}

	public static int getFactors(int num) {
		int factors = 0;
		for (int i = 1; i <= (num / 2); i++) {
			if (num % i == 0) {
				factors++;
			}
		}
		if (factors > 100) {
			System.out.println(num + ": " + (factors + 1) + " factors");
		}
		return factors + 1;
	}

	public static int factors(int num) {
		int factors = 0;
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				factors++;
			}
		}
		if (factors > 100) {
			System.out.println(num + ": " + (factors * 2) + " factors");
		}
		return factors * 2;
	}
}
