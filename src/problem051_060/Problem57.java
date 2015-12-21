package problem051_060;

import java.math.BigInteger;

public class Problem57 {
	public static void main(String args[]) {
		BigInteger n = BigInteger.ONE;
		BigInteger d = BigInteger.ONE;

		int result = 0;

		for (int i = 1; i < 1000; i++) {
			BigInteger oldn = n;
			BigInteger oldd = d;
			d = oldn.add(oldd);
			n = d.add(oldd);

			System.out.print(n + "/" + d);

			if ((d + "").length() < (n + "").length()) {
				result++;
				System.out.println(" +");
			} else {
				System.out.println(" -");
			}

		}
		System.out.println(result);
	}
}
