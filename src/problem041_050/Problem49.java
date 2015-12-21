package problem041_050;

import euler.util.PrimeChecker;

/**
 * Problem49.java 
 */

/**
 * @author Josh Wight
 *
 */
public class Problem49 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1000; i < 10000; i++) {
			if (PrimeChecker.check(i)) {
				for (int j = 1; (i + (2 * j)) < 10000; j++) {
					int i1 = i + j;
					int i2 = i + (2 * j);
					if (PrimeChecker.check(i1) && PrimeChecker.check(i2) && permutations(i, i1, i2)) {
						System.out.println(i + " " + i1 + " " + i2);
					}
				}
			}
		}
	}

	static boolean permutations(int a, int b, int c) {
		int aa[] = digitCountArray(a);
		int ba[] = digitCountArray(b);
		int ca[] = digitCountArray(c);

		for (int i = 0; i < 10; i++) {
			if (!(aa[i] == ba[i] && aa[i] == ca[i])) {
				return false;
			}
		}
		return true;
	}

	static int[] digitCountArray(int num) {
		String s = "" + num;
		int a[] = new int[10];
		for (int i = 0; i < s.length(); i++) {
			a[Integer.valueOf(s.substring(i, i + 1))]++;
		}
		return a;
	}

}
