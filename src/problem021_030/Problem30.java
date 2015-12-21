package problem021_030;
/**
 * Problem30.java 
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
public class Problem30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 10; i < 1000000; i++) {
			if (check(i)) {
				sum += i;
				System.out.println("Found " + i + ". Sum so far: " + sum);
			}
		}
	}

	public static boolean check(int num) {
		int numDigits = 1 + (int) Math.log10(num);
		int[] digits = new int[numDigits];
		digits[0] = num % 10;
		for (int i = 1; i < numDigits; i++) {
			int a = num % (int) (Math.pow(10, i + 1));
			for (int j = i - 1; j > 0; j--) {
				a -= digits[j] * Math.pow(10, j);
			}
			a /= (int) (Math.pow(10, i));
			digits[i] = a;
		}
		int sum = 0;
		for (int i = numDigits - 1; i >= 0; i--) {
			sum += Math.pow(digits[i], 5);
			// System.out.print("" + digits[i]);
		}
		// System.out.println();

		return sum == num;
	}

}
