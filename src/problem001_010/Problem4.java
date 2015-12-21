package problem001_010;
/**
 * Problem4.java 
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
public class Problem4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 0;
		int maxJ = 0;
		for (int i = 999; i >= 100; i--) {
			if (i < maxJ) {
				break;
			}
			for (int j = 999; j >= 100; j--) {
				if (i * j > max && checkPalindrome(i * j)) {
					max = i * j;
					maxJ = j;
				}
			}
		}
		System.out.println(max + "");

	}

	public static boolean checkPalindrome(int num) {
		String numStr = "" + num;
		int len = numStr.length();
		for (int a = 0; a < len / 2; a++) {
			if (!(numStr.charAt(a) == numStr.charAt(len - a - 1))) {
				return false;
			}
		}
		return true;
	}

}
