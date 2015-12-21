package problem021_030;

import java.util.ArrayList;

/**
 * Problem23.java 
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
public class Problem23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[28123];
		ArrayList<Integer> abundants = new ArrayList<Integer>();

		for (int i = 1; i <= 28123; i++) {
			nums[i - 1] = i;
			if (abundant(i)) {
				abundants.add(i);
			}
		}
		System.out.println(abundants.size() + " abundant numbers");
		for (int i = 0; i < abundants.size(); i++) {
			System.out.println("starting cycle with " + abundants.get(i));
			for (int j = i; j < abundants.size(); j++) {
				int num = abundants.get(i) + abundants.get(j);
				if (num <= 28123)
					nums[num - 1] = 0;
			}
		}

		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		System.out.println("" + sum);
	}

	public static boolean abundant(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum > n;
	}
}
