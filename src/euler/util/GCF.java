package euler.util;
/**
 * GCF.java 
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
public class GCF {
	// a must be smaller than b
	public static int gcf(int a, int b) {
		int g = 1;
		for (int i = 2; (i <= a && i * i <= b); i++) {
			while (a % i == 0 && b % i == 0) {
				g *= i;
				b /= i;
				a /= i;
			}
		}
		return g;
	}
}
