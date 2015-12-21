package euler.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * LargeInt.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * Don't use this. BigInteger is a thing. Keeping this for legacy purposes.
 * 
 * @author Josh Wight
 *
 */
public class LargeInt implements Comparable {
	public ArrayList<Integer> digits;

	public LargeInt(int i) {
		digits = new ArrayList<Integer>();
		digits.add(i);
		rectify();
	}

	public LargeInt(LargeInt i) {
		digits = new ArrayList<Integer>();
		for (int a : i.digits) {
			digits.add(a);
		}
	}

	public int get(int i) {
		return digits.get(i);
	}

	private void rectify() {
		for (int i = 0; i < digits.size(); i++) {
			int num = digits.get(i);
			if (num >= 10) {
				int newNum = num % 10;
				digits.set(i, newNum);
				int extra = (num - newNum) / 10;
				if (i + 1 >= digits.size()) {
					digits.add(0);
				}
				int next = digits.get(i + 1);
				digits.set(i + 1, next + extra);
			}
		}
	}

	public void trimZeroes() {
		while (digits.get(digits.size() - 1) == 0 && digits.size() > 1) {
			digits.remove(digits.size() - 1);
		}
	}

	public void mult(int i) {
		i = Math.abs(i);
		for (int a = 0; a < digits.size(); a++) {
			int num = digits.get(a);
			digits.set(a, num * i);
		}
		rectify();
	}

	public void add(int i) {
		i = Math.abs(i);

		int num = digits.get(0);
		digits.set(0, num + i);
		rectify();
	}

	public void add(LargeInt i) {
		for (int a = 0; a < i.digits.size(); a++) {
			int digit = i.digits.get(a);
			if (a >= digits.size()) {
				digits.add(digit);
			} else {
				int old = digits.get(a);
				digits.set(a, old + digit);
			}
		}
		rectify();
	}

	public void setDigits(Integer[] d) {
		digits.clear();
		digits.addAll(Arrays.asList(d));
	}

	public void print() {
		for (int i = digits.size() - 1; i >= 0; i--) {
			System.out.print(digits.get(i));
		}
		System.out.println();
	}

	public boolean equals(Object other) {
		if (other instanceof LargeInt) {
			LargeInt i = (LargeInt) other;
			return digits.equals(i.digits);
		}
		return false;
	}

	public int compareTo(Object other) {
		if (other instanceof LargeInt) {
			LargeInt i = (LargeInt) other;
			if (i.digits.size() == digits.size()) {
				for (int j = digits.size() - 1; j >= 0; j--) {
					if (digits.get(j) < i.digits.get(j)) {
						return -1;
					} else if (digits.get(j) > i.digits.get(j)) {
						return 1;
					}
				}
				return 0;
			} else if (digits.size() < i.digits.size()) {
				return -1;
			} else if (digits.size() > i.digits.size()) {
				return 1;
			}
		}
		return -1;
	}

	public LargeInt reverse() {
		LargeInt i = new LargeInt(digits.get(digits.size() - 1));
		for (int j = digits.size() - 2; j >= 0; j--) {
			i.digits.add(digits.get(j));
		}
		return i;
	}

	public boolean isPalindromic() {
		int i = 0;
		int j = digits.size() - 1;
		while (i < j) {
			if (!(digits.get(i) == digits.get(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static LargeInt makeExp(int i, int exp) {
		LargeInt l = new LargeInt(1);
		for (int j = 0; j < exp; j++) {
			l.mult(i);
		}
		return l;
	}
}
