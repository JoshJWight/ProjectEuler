package problem031_040;

/**
 * Problem38.java 
 */
import java.math.*;
import java.util.ArrayList;

/**
 * @author Josh Wight
 *
 */
public class Problem38 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger n = BigInteger.ZERO;

		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10000; j++) {
				String s = "";
				for (int k = 1; k <= i; k++) {
					s += (j * k);
				}
				if (isPandigital(s)) {
					BigInteger m = new BigInteger(s);
					if (m.compareTo(n) > 0) {
						System.out.println(j + ", " + i + " -> " + m + " > " + n);
						n = m;
					}
				}
			}
		}
	}

	private static boolean isPandigital(String s) {
		if (s.length() != 9) {
			return false;
		}
		for (int i = 1; i <= 9; i++) {
			String n = "" + i;
			if (!s.contains(n)) {
				return false;
			}
		}
		return true;
	}

}
