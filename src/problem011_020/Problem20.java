package problem011_020;

import euler.util.LargeInt;

/**
 * Problem20.java 
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
public class Problem20 {
	public static void main(String[] args) {
		LargeInt i = new LargeInt(1);
		for (int a = 2; a <= 100; a++) {
			i.mult(a);
		}
		int sum = 0;
		for (int a : i.digits) {
			sum += a;
		}
		System.out.println(sum + "");
	}
}
