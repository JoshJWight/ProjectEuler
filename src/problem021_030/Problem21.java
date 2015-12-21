package problem021_030;
/**
 * Problem21.java 
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
public class Problem21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 2; i < 10000; i++) {
			int d = d(i);
			if (d != i && d(d) == i) {
				sum += i;
			}
		}
		System.out.println("" + sum);

	}

	public static int d(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

}
