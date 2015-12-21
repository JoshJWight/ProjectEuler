package problem071_080;
/**
 * Problem71.java 
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
public class Problem71 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double t = 3.0 / 7.0;
		double max = 0;
		int maxn = 0;
		int maxd = 0;

		for (int i = 8; i <= 1000000; i++) {
			int d = i;
			int n = d * 3 / 7;

			int g = gcf(n, d);

			d /= g;
			n /= g;

			double r = (double) n / (double) d;
			if (r < t) {
				if (r > max) {
					max = r;
					maxn = n;
					maxd = d;
				}
			}
		}
		System.out.println(maxn + " / " + maxd);

	}

	// a must be smaller than b
	public static int gcf(int a, int b) {
		int g = 1;
		for (int i = 2; (i <= a && i * i <= b); i++) {
			while (a % i == 0 && b % i == 0) {
				g *= i;
				b /= i;
				a /= i;
			}
		}
		return g;
	}

}
