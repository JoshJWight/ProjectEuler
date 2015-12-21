package problem031_040;
/**
 * Problem39.java 
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
public class Problem39 {
	private static int[] counts;

	public static void main(String[] args) {
		counts = new int[1001];
		for (int i = 0; i < 1001; i++) {
			counts[i] = 0;
		}

		for (int i = 1; i < 1000; i++) {
			for (int j = 1; j < 1000; j++) {
				check(i, j);
			}
		}

		int max = 0;
		int maxCount = 0;
		for (int i = 1; i <= 1000; i++) {
			if (counts[i] > maxCount) {
				maxCount = counts[i];
				max = i;
			}
		}

		System.out.println(max + ", with " + maxCount + " combinations.");

	}

	public static void check(int i, int j) {
		double k = Math.sqrt((double) (i * i + j * j));
		if ((double) (int) k != k) {
			return;
		}
		int p = i + j + (int) k;
		if (p <= 1000) {
			System.out.println("found {" + i + ", " + j + ", " + (int) k + "} = " + p);
			counts[p] = counts[p] + 1;
		}
	}

}
