package problem021_030;
/**
 * Problem29.java 
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
public class Problem29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[][] = new int[101][601];

		int total = 0;
		for (int a = 2; a <= 100; a++) {
			int root = lowestRoot(a);
			int exp = 0;
			if (root != 0) {
				exp = (int) (Math.log(a) / Math.log(root));
				System.out.println(a + " = " + root + " ^ " + exp);
			}

			for (int b = 2; b <= 100; b++) {
				arr[a][b] = 1;

				if (root != 0) {
					if (arr[root][b * exp] == 0) {
						total++;
						arr[root][b * exp] = 1;
					}
				} else {
					total++;
				}
			}
		}
		System.out.println(total);
	}

	static int lowestRoot(int n) {
		for (int i = 2; i * i <= n; i++) {
			for (int j = 2; j <= 6; j++) {
				if (Math.pow(i, j) == n) {
					return i;
				}
			}
		}
		return 0;
	}

}
