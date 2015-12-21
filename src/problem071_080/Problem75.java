package problem071_080;

import java.util.TreeSet;

/**
 * Problem75.java 
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
public class Problem75 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<Integer> lengths = new TreeSet<Integer>();
		TreeSet<Integer> lengths2 = new TreeSet<Integer>();

		for (int a = 2; a < 750000; a++) {
			System.out.println("a = " + a);
			for (int b = 1; b < a; b++) {
				int per = a + b + (int) Math.sqrt(a * a + b * b);
				if (per > 1500000) {
					break;
				}
				if (isSquare(a * a + b * b)) {
					if (!lengths.contains(per)) {
						lengths.add(per);
					} else {
						lengths2.add(per);
					}
				}
			}
		}
		System.out.println(lengths.size() - lengths2.size());

	}

	public static boolean isSquare(int n) {
		double r = Math.sqrt(n);
		return (double) (int) r == r;
	}

}
