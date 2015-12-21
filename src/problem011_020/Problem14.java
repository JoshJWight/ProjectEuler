package problem011_020;

import euler.util.FactorChecker;

/**
 * Problem14.java 
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
public class Problem14 {

	public static void main(String[] args) {
		int max = 0;
		int maxLen = 0;
		for (int i = 1; i < 1000000; i++) {
			int l = len(i);
			if (l > maxLen) {
				max = i;
				maxLen = l;
				System.out.println("New max: " + i + ", with " + l);
			}
		}
		System.out.println("" + max);
	}

	public static int len(int num) {
		double n = num;
		int len = 0;
		while (n != 1) {
			if (FactorChecker.check(n, 2)) {
				n = n / 2;
			} else {
				n = (3 * n) + 1;
			}
			len++;
		}

		return len;
	}

	// Original attempt. Didn't work.
	/*
	 * public static void main(String[] args) { int max=0; int maxlen=0;
	 * 
	 * for(int i=1; i<1000000; i++) {
	 * 
	 * int num=i; int len=1; while(num>1) { len++; if(num%2==0) { num=num/2; }
	 * else{ num = (3*num) +1; } } if(len>maxlen) { System.out.println(i + ": "
	 * + len); maxlen=len; max=i; } } System.out.println(max+""); }
	 */
}
