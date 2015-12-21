package problem001_010;
/**
 * Problem2.java 
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
public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		int i = 1, j = 1, k = 1;
		while (k <= 4000000) {
			k = i + j;
			i = j;
			j = k;
			if (k % 2 == 0) {
				sum += k;
			}
		}
		System.out.println(sum + "");

	}

}
