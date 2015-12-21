package problem081_090;
/**
 * Problem86.java 
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
public class Problem86 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m = 1;
		int t = 0;
		while (true) {
			t += get(m);
			if (t > 1000000) {
				System.out.println(m + "");
				break;
			}
			m++;
		}

	}

	public static int get(int m) {
		int t = 0;
		for (int x = 1; x <= m; x++) {
			for (int y = 1; y <= x; y++) {
				int z2 = (x + y) * (x + y) + m * m;
				double z = Math.sqrt(z2);
				if ((double) (int) z == z) {
					t++;
				}
			}
		}
		return t;

	}

}
