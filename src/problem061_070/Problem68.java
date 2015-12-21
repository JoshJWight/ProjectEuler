package problem061_070;

import java.util.ArrayList;

import euler.util.PandigitalIterator;

/**
 * Problem68.java 
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
public class Problem68 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PandigitalIterator p = new PandigitalIterator(1, 10);
		int[] ring = p.nextArr();
		int[] last = null;

		ArrayList<Integer> max = null;

		while (ring != last) {
			if (check16(ring)) {
				if (checkMagic(ring)) {
					ArrayList<Integer> a = description(ring);
					System.out.print("Candidate: ");
					print(a);
					if (max == null) {
						max = a;
					} else if (isLarger(a, max)) {
						max = a;
					}
				}
			}

			last = ring;
			ring = p.nextArr();
		}
		print(max);

	}

	public static void print(ArrayList<Integer> a) {
		for (int i : a) {
			System.out.print("" + i);
		}
		System.out.println();
	}

	public static boolean checkMagic(int[] ring) {
		int a = ring[1] + ring[2] + ring[4];
		int b = ring[3] + ring[4] + ring[6];
		int c = ring[5] + ring[6] + ring[8];
		int d = ring[7] + ring[8] + ring[0];
		int e = ring[9] + ring[0] + ring[2];

		return (a == b && a == c && a == d && a == e);
	}

	public static boolean check16(int[] ring) {
		return (ring[1] == 10 || ring[3] == 10 || ring[5] == 10 || ring[7] == 10 || ring[9] == 10);
	}

	// determines if a is larger than b
	public static boolean isLarger(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a.size() > b.size()) {
			return true;
		} else if (b.size() > a.size()) {
			return false;
		} else {
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) > b.get(i)) {
					return true;
				} else if (a.get(i) < b.get(i)) {
					return false;
				}
			}
		}
		return false;
	}

	public static ArrayList<Integer> description(int[] ring) {
		ArrayList<Integer> d = new ArrayList<Integer>();
		int min = 11;
		int mini = 0;
		for (int i = 1; i <= 9; i += 2) {
			if (ring[i] < min) {
				mini = i;
				min = ring[i];
			}
		}

		for (int i = mini; i <= mini + 8; i += 2) {
			int i1 = i % 10;
			int i2 = (i + 1) % 10;
			int i3 = (i + 3) % 10;

			if (ring[i1] == 10) {
				d.add(1);
				d.add(0);
			} else {
				d.add(ring[i1]);
			}
			if (ring[i2] == 10) {
				d.add(1);
				d.add(0);
			} else {
				d.add(ring[i2]);
			}
			if (ring[i3] == 10) {
				d.add(1);
				d.add(0);
			} else {
				d.add(ring[i3]);
			}
		}

		return d;
	}

}
