package problem011_020;
/**
 * Problem17.java 
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
public class Problem17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		sum += 11;// "One thousand"
		for (int i = 1; i < 1000; i++) {
			sum += numberLetters(i);
		}
		System.out.println(sum + "");
	}

	public static int numberLetters(int num) {
		num = num % 1000;
		int ones = (num % 10);
		int tens = ((num % 100) - num % 10) / 10;
		int hundreds = (num - (num % 100)) / 100;

		int sum = 0;
		if (ones == 0 && tens == 0) {
			sum += hundredLetters(hundreds, true);
		} else {
			sum += hundredLetters(hundreds, false);
		}

		if (tens == 1) {
			sum += teenLetters(ones);
		} else {
			sum += tensLetters(tens);
			sum += digitLetters(ones);
		}
		System.out.println(hundreds + "" + tens + "" + ones + ": " + sum);

		return sum;

	}

	public static int digitLetters(int digit) {
		switch (digit) {
		case 1:
			return 3;// "one"
		case 2:
			return 3;// "two"
		case 3:
			return 5;// "three"
		case 4:
			return 4;// "four"
		case 5:
			return 4;// "five"
		case 6:
			return 3;// "six"
		case 7:
			return 5;// "seven"
		case 8:
			return 5;// "eight"
		case 9:
			return 4;// "nine"
		default:
			return 0;
		}
	}

	public static int hundredLetters(int digit, boolean singleton) {
		if (digit == 0) {
			return 0;
		} else if (singleton) {
			return digitLetters(digit) + 7;// "X hundred"
		} else {
			return digitLetters(digit) + 10;// "X hundred and"
		}
	}

	// use the ONES digit
	public static int teenLetters(int digit) {
		switch (digit) {
		case 1:
			return 6;// "eleven"
		case 2:
			return 6;// "twelve"
		case 3:
			return 8;// "thirteen"
		case 4:
			return 8;// "fourteen"
		case 5:
			return 7;// "fifteen"
		case 6:
			return 7;// "sixteen"
		case 7:
			return 9;// "seventeen"
		case 8:
			return 8;// "eighteen"
		case 9:
			return 8;// "nineteen"
		case 0:
			return 3;// "ten"
		default:
			return 0;
		}
	}

	public static int tensLetters(int digit) {
		switch (digit) {
		case 2:
			return 6;// "twenty"
		case 3:
			return 6;// "thirty"
		case 4:
			return 5;// "forty"
		case 5:
			return 5;// "fifty"
		case 6:
			return 5;// "sixty"
		case 7:
			return 7;// "seventy"
		case 8:
			return 6;// "eighty"
		case 9:
			return 6;// "ninety"
		default:
			return 0;
		}
	}

}
