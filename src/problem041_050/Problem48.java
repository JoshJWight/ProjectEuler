package problem041_050;
/**
 * Problem48.java 
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
public class Problem48 {

	public static void main(String[] args) {
		double lastTen = 0;
		for (int i = 1; i <= 1000; i++) {
			lastTen += get(i);
			lastTen = lastTen % 10000000000.0;
		}
		System.out.println(lastTen);

	}

	public static double get(double i) {
		double num = 1;
		for (int j = 0; j < i; j++) {
			num *= i;
			num = num % 10000000000.0;
		}
		return num;

	}

}
