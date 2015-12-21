package problem041_050;

import euler.util.FactorChecker;
import euler.util.LargeInt;
import euler.util.PandigitalIterator;

/**
 * Problem43.java 
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
public class Problem43 {

	public static void main(String[] args) {
		PandigitalIterator it = new PandigitalIterator(0, 9);
		LargeInt sum = new LargeInt(0);
		LargeInt last = new LargeInt(0);
		LargeInt cur = it.nextLargeInt();
		while (!cur.equals(last)) {
			if (check(cur)) {
				sum.add(cur);
				System.out.print("found ");
				cur.print();
			}
			last = cur;
			cur = it.nextLargeInt();
		}
		sum.print();

	}

	public static boolean check(LargeInt i) {
		int a = i.get(8) * 100 + i.get(7) * 10 + i.get(6);
		int b = i.get(7) * 100 + i.get(6) * 10 + i.get(5);
		int c = i.get(6) * 100 + i.get(5) * 10 + i.get(4);
		int d = i.get(5) * 100 + i.get(4) * 10 + i.get(3);
		int e = i.get(4) * 100 + i.get(3) * 10 + i.get(2);
		int f = i.get(3) * 100 + i.get(2) * 10 + i.get(1);
		int g = i.get(2) * 100 + i.get(1) * 10 + i.get(0);
		if (!FactorChecker.check(a, 2)) {
			return false;
		}
		if (!FactorChecker.check(b, 3)) {
			return false;
		}
		if (!FactorChecker.check(c, 5)) {
			return false;
		}
		if (!FactorChecker.check(d, 7)) {
			return false;
		}
		if (!FactorChecker.check(e, 11)) {
			return false;
		}
		if (!FactorChecker.check(f, 13)) {
			return false;
		}
		if (!FactorChecker.check(g, 17)) {
			return false;
		}

		return true;
	}

}
