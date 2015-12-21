package problem061_070;
/**
 * Problem66.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * @author Pharaun
 *
 */
public class Problem66 {

	public static void main(String[] args) {
		double maxi = 0;
		double max = 0;
		for (double i = 1; i <= 1000; i++) {
			double result = solve(i);
			if (result > max) {
				max = result;
				maxi = i;
			}
		}
		System.out.println("Max x: " + max + " at D=" + maxi);
	}

	private static double solve(double d) {
		if (isSquare(d)) {
			return 0;
		}
		for (double y = 1; y < 1000000000; y++) {
			double xs = (y * y * d) + 1;
			if (xs > 0 && isSquare(xs)) {
				// System.out.println(Math.sqrt(xs) + "^2 - " + d + " * " + y +
				// "^2 = 1");
				return Math.sqrt(xs);
			}
		}
		System.out.println("No solution for D=" + d);
		return 0;
	}

	private static boolean isSquare(double i) {
		double s = Math.sqrt(i);
		return Math.floor(s) == s;
	}
}
