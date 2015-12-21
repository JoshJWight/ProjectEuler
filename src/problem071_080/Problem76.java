package problem071_080;
/**
 * Problem76.java 
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
public class Problem76 {

	public static int[] nums;

	public static void main(String[] args) {
		nums = new int[100];
		for (int i = 0; i < 100; i++) {
			nums[i] = 0;
		}
		int total = 0;
		for (int i = 1; i <= 99; i++) {
			System.out.println("i = " + i);
			nums[0] = i;
			total += combos();
		}
		System.out.println("" + total);

	}

	public static int combos() {
		int combos = 0;
		int loc = 0;
		for (int i = 1; i < 100; i++) {
			if (nums[i] == 0) {
				loc = i;
				break;
			}
		}
		int t = total();
		for (int i = 1; i <= nums[loc - 1]; i++) {
			nums[loc] = i;
			if (t + i == 100) {
				combos += 1;
				break;
			} else {
				combos += combos();
			}

		}
		nums[loc] = 0;
		return combos;

	}

	public static int total() {
		int t = 0;
		for (int i = 0; i < 100; i++) {
			t += nums[i];
			if (nums[i] == 0) {
				break;
			}
		}
		return t;
	}

}
