package problem031_040;

import euler.util.PrimeChecker;

/**
 * Problem35.java 
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
public class Problem35 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 0;
		for (int i = 2; i < 1000000; i++) {
			if (check(i)) {
				System.out.println("Found " + i);
				num++;
			}
		}
		System.out.println("" + num);

	}

	public static boolean check(int num) {
		int i = num;
		do {

			if (!PrimeChecker.check(i)) {
				return false;
			}

			int last = i % 10;
			int factor = 1;
			while (factor < i) {
				factor *= 10;
			}
			i += last * factor;
			i = i / 10;

		} while (i != num);

		return true;
	}

}
