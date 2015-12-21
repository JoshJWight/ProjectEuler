package problem001_010;
/**
 * Problem1.java 
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
public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		for (int a = 0; a < 1000; a++) {
			if (a % 3 == 0 || a % 5 == 0) {
				sum += a;
			}
		}
		System.out.println(sum + "");

	}

}
