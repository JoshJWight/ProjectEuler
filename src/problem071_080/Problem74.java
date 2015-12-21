package problem071_080;

import java.util.ArrayList;

import euler.util.DigitCounter;

/**
 * Problem74.java 
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
public class Problem74 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int num = 0;
		for (int i = 1; i < 1000000; i++) {
			int len = 0;
			ArrayList<Integer> chain = new ArrayList<Integer>();
			int n = i;
			while (!chain.contains(n)) {
				len++;
				chain.add(n);
				n = next(n);
			}
			if (len == 60) {
				num++;
				System.out.println("" + i);
			}
		}
		System.out.println(num + "");

	}

	public static int next(int n) {
		int[] digits = DigitCounter.digits(n);

		int sum = 0;
		for (int i : digits) {
			int j = 1;
			for (int k = 2; k <= i; k++) {
				j *= k;
			}
			sum += j;
		}
		return sum;
	}

}
