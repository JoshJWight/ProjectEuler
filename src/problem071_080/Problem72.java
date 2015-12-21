package problem071_080;

import euler.util.Totient;

/**
 * Problem72.java 
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
public class Problem72 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double n = 0;
		for (int i = 2; i <= 1000000; i++) {
			n += Totient.phi(i);
		}
		System.out.println(n + "");

	}

}
