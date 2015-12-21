package problem071_080;

import euler.util.GCF;

/**
 * Problem73.java 
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
public class Problem73 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double a = 1.0 / 3.0;
		double b = 1.0 / 2.0;
		int n = 0;
		for (int i = 5; i <= 12000; i++) {
			for (int j = (i / 3) - 1; j <= (i / 2) + 1; j++) {
				if (GCF.gcf(j, i) == 1) {
					double r = (double) j / (double) i;

					if (r > a && r < b) {
						System.out.println(j + " / " + i);
						n++;
					}
				}
			}
		}
		System.out.println(n + "");

	}

}
