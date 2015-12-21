package problem001_010;
/**
 * Problem6.java 
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
public class Problem6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		int sumOfSquares = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
			sumOfSquares += (i * i);

		}
		int squareOfSum = sum * sum;
		System.out.println("" + (squareOfSum - sumOfSquares));

	}

}
