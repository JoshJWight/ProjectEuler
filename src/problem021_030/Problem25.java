package problem021_030;

import euler.util.LargeInt;

/**
 * Problem25.java 
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
public class Problem25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LargeInt a = new LargeInt(1);
		LargeInt b = new LargeInt(1);

		int f = 3;

		while (true) {
			LargeInt c = new LargeInt(a);
			c.add(b);
			a = b;
			b = c;

			if (c.digits.size() >= 1000) {
				System.out.println("" + f);
				return;
			}

			f++;
		}

	}

}
