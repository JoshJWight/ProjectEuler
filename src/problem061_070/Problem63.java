package problem061_070;

import euler.util.LargeInt;

/**
 * Problem63.java 
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
public class Problem63 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 1;
		int nums = 0;
		while (true) {
			int i = get(n);
			nums += i;
			System.out.println(i + " nums for " + n + ". " + nums + " total.");

			n++;
		}

	}

	public static int get(int n) {
		int i = 1;
		int total = 0;
		while (true) {
			LargeInt l = LargeInt.makeExp(i, n);
			if (l.digits.size() == n) {
				total++;
			} else if (l.digits.size() > n) {
				return total;
			}
			i++;
		}
	}

}
