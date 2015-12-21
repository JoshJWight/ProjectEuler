package problem081_090;
/**
 * Problem85.java 
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
public class Problem85 {

	public static void main(String[] args) {

		int mark = 0;
		int dist = 2000000;
		int x = 1;
		while (true) {
			for (int y = x; y > 0; y--) {
				int r = rectangles(x, y);
				int d = Math.abs(r - 2000000);
				if (d < dist) {
					mark = r;
					dist = d;
					System.out.println("Found (" + x + ", " + y + "). " + r + " rectangles. Area: " + x * y);
				}
				if (r < 2000000) {
					break;
				}
			}
			x++;
		}
	}

	public static int rectangles(int x, int y) {
		int r = 0;

		for (int l = 1; l <= x; l++) {
			for (int w = 1; w <= y; w++) {
				r += (x - l + 1) * (y - w + 1);
			}
		}

		return r;
	}
}
