package problem021_030;

import euler.util.PandigitalIterator;

/**
 * Problem24.java 
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
public class Problem24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PandigitalIterator p = new PandigitalIterator(0, 9);
		double n = 0;
		for (int i = 0; i < 1000000; i++) {
			n = p.nextDouble();
		}
		System.out.println(n);
	}

}
