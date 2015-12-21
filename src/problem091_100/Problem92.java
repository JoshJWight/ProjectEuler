package problem091_100;

import euler.util.DigitCounter;

/**
 * Problem92.java 
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
public class Problem92 {

	private static int[] cache;

	public static void main(String[] args) {
		cache = new int[10000000];
		cache[1] = 1;
		cache[89] = 89;
		int t = 0;
		for (int i = 1; i < 10000000; i++) {
			if (get(i) == 89) {
				t++;
			}
		}
		System.out.println(t);

	}

	public static int get(int i) {
		if (cache[i] == 1) {
			return 1;
		} else if (cache[i] == 89) {
			return 89;
		} else {
			int[] digits = DigitCounter.digits(i);
			int num = 0;
			for (int j : digits) {
				num += j * j;
			}
			int k = get(num);
			cache[i] = k;
			return k;
		}
	}

}
