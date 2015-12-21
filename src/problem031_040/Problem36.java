package problem031_040;
/**
 * Problem36.java 
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
public class Problem36 {
	public static void main(String args[]) {
		int sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (checkTen(i) && checkTwo(i)) {
				sum += i;
			}
		}
		System.out.println("" + sum);
	}

	public static boolean checkTen(int num) {
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

		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != digits[digits.length - i - 1]) {
				return false;
			}
		}

		return true;
	}

	public static boolean checkTwo(int num) {
		int numDigits = 1 + (int) (Math.log10(num) / Math.log10(2));
		int[] digits = new int[numDigits];
		digits[0] = num % 2;
		for (int i = 1; i < numDigits; i++) {
			int a = num % (int) (Math.pow(2, i + 1));
			for (int j = i - 1; j > 0; j--) {
				a -= digits[j] * Math.pow(2, j);
			}
			a /= (int) (Math.pow(2, i));
			digits[i] = a;
		}
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != digits[digits.length - i - 1]) {
				return false;
			}
		}
		System.out.print("found ");
		for (int i : digits) {
			System.out.print(i + "");
		}
		System.out.println(" (" + num + ")");
		return true;

	}
}
