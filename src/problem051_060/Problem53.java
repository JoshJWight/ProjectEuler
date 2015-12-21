package problem051_060;
/**
 * Problem53.java 
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
public class Problem53 {

	public static void main(String[] args) {
		int total = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r <= n; r++) {
				if (result(n, r) > 1000000) {
					total++;
				}
			}
		}
		System.out.println(total);

	}

	public static double result(int n, int r) {
		return factorial(n) / (factorial(r) * factorial(n - r));
	}

	public static double factorial(int i) {
		double result = 1;
		for (int j = 2; j <= i; j++) {
			result *= j;
		}
		return result;
	}

}
