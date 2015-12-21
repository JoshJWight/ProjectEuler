package euler.util;
/**
 * DigitCounter.java 
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
public class DigitCounter {
	public static int count(int num) {
		return 1 + (int) Math.log10(num);
	}

	public static int[] digits(int num) {
		int numDigits = count(num);
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
		return digits;
	}

	public static int num(int[] digits) {
		int num = 0;
		int factor = 1;
		for (int i = 0; i < digits.length; i++) {
			num += factor * digits[i];
			factor *= 10;
		}
		return num;
	}

	public static int[] pattern(int num) {
		int[] pattern = new int[10];
		for (int i = 0; i < 10; i++) {
			pattern[i] = 0;
		}
		for (int i : digits(num)) {
			pattern[i] = pattern[i] + 1;
		}
		return pattern;
	}
}
