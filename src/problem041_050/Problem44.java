package problem041_050;

import java.util.ArrayList;

/**
 * Problem44.java 
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
public class Problem44 {
	public static ArrayList<Integer> pents;

	public static void main(String[] args) {

		pents = new ArrayList<Integer>();
		pents.add(0);

		int mini = 0;
		int minj = 0;
		int mind = 0;

		int i = 2;
		while (true) {
			System.out.println("checking i = " + i);
			int penti = pent(i);
			for (int j = 1; j < i; j++) {
				int pentj = pent(j);
				if (checkPent(penti - pentj) && checkPent(penti + pentj)) {
					int d = penti - pentj;
					if (d < mind || mind == 0) {
						mind = d;
						mini = i;
						minj = j;
					}
					System.out.println("found (" + i + ", " + j + ", " + d + "). Min so far: (" + mini + ", " + minj
							+ ", " + mind + ")");
				}
			}
			i++;
		}

	}

	public static boolean checkPent(int num) {
		if (pents.contains(num)) {
			return true;
		} else if (pents.get(pents.size() - 1) > num) {
			return false;
		}
		int i = pents.size();
		int pent = pent(i);
		while (pent <= num) {
			pents.add(pent);
			if (pent == num) {
				return true;
			}
			i++;
			pent = pent(i);

		}
		return false;
	}

	public static int pent(int i) {
		return i * (3 * i - 1) / 2;
	}

}
