package problem041_050;
/**
 * Problem45.java 
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
public class Problem45 {
	public static void main(String[] args) {
		for (double i = 0; i < 1000000; i++) {
			double pent = i * (3 * i - 1) / 2;
			// System.out.println("i: " + i + ", pent: " + pent);
			if (checkTriangle(pent) && checkHexagonal(pent)) {
				System.out.println(i + ": " + pent);
			}
		}
	}

	private static boolean checkTriangle(double n) {
		double root = Math.sqrt(2 * n);

		// System.out.println("Triangle: root: " + root);
		// System.out.println("Product: " + (Math.ceil(root) * Math.floor(root)
		// / 2));

		return (Math.ceil(root) * Math.floor(root) / 2) == n;

	}

	private static boolean checkHexagonal(double n) {
		double root = Math.sqrt(n / 2);

		// System.out.println("Hex: root: " + root);
		// System.out.println("Product: " + (Math.ceil(root) * (2 *
		// Math.ceil(root) - 1)));

		return (Math.ceil(root) * (2 * Math.ceil(root) - 1)) == n;
	}

}
