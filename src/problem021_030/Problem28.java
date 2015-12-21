package problem021_030;
/**
 * Problem28.java 
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
public class Problem28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 1;
		int side = 3;
		int inc = 1;
		while (side <= 1001) {
			for (int i = 0; i < 4; i++) {
				inc += side - 1;
				sum += inc;
			}
			side += 2;
		}
		System.out.println(sum + "");

	}

}
