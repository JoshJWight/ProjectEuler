package problem061_070;

import euler.util.DigitIterator;
import euler.util.LargeInt;

/**
 * Problem62.java 
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
public class Problem62 {

	/**
	 * @param args
	 */
	// the cube values are getting higher than int can hold.
	public static void main(String[] args) {
		int i = 405;
		while (true) {
			i++;
			LargeInt cube = new LargeInt(i);
			cube.mult(i);
			cube.mult(i);
			int c = cubes(cube);
			System.out.println(i + ": " + c + " cubes");
			if (c == 5) {
				break;
			}
		}

	}

	public static int cubes(LargeInt num) {
		int cubes = 0;
		DigitIterator d = new DigitIterator(num);

		LargeInt n = d.nextLargeInt();
		LargeInt last = new LargeInt(0);
		while (!n.equals(last)) {
			if (isCube(n)) {
				cubes++;
			}

			last = n;
			n = d.nextLargeInt();
		}
		return cubes;
	}

	public static boolean isCube(LargeInt num) {
		double d = 0;
		for (int i = num.digits.size() - 1; i >= 0; i--) {
			d += Math.pow(10, i) * num.digits.get(i);
		}
		d = Math.pow(d, 1.0 / 3.0);

		int i = (int) d - 1;

		while (true) {
			LargeInt j = new LargeInt(i);
			j.mult(i);
			j.mult(i);

			if (j.equals(num)) {
				return true;
			} else if (j.compareTo(num) > 0) {
				return false;
			}
			i++;
		}

		/*
		 * double n = num; double r = Math.pow(n, 1.0/3.0); if((double)(int)r ==
		 * r) { return true; } return false;
		 */
	}

}
