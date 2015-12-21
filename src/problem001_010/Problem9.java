package problem001_010;
/**
 * Problem9.java 
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
public class Problem9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int prod = 0;
		for (int a = 1; a < 999; a++) {
			for (int b = 1; b < (999 - a); b++) {
				int c = 1000 - a - b;
				if (a * a + b * b == c * c) {
					prod = a * b * c;
					System.out.println(prod + "");
					return;
				}

			}
		}

	}

}
