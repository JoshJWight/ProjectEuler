package problem011_020;

import euler.util.LargeInt;

/**
 * Problem16.java 
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
public class Problem16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LargeInt i = new LargeInt(1);
		for (int a = 0; a < 1000; a++) {
			i.mult(2);
		}
		i.print();

		int sum = 0;
		for (Integer a : i.digits) {
			sum += a;
		}
		System.out.println(sum + "");
	}

}
