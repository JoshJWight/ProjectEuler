package problem121_130;

import java.util.ArrayList;

import euler.util.BasicMath;

public class Problem127 {
	
	public static long radicals[];

	public static void main(String[] args) {
		radicals = new long[120000];
		for(int i=1; i<120000; i++) {
			radicals[i] = BasicMath.radical(i);
		}
		System.out.println("radicals filled");
		
		long sum = 0;
		
		for(int c = 3; c<120000; c++) {
			for(int a=1; a<(double)c/2.0; a++) {
				int b = c-a;
				if(abcHit(a, b, c)) {
					sum+=c;
					System.out.println(a + ", " + b + ", " + c);
				}
			}
		}
		System.out.println(sum);

	}
	
	public static boolean abcHit(int a, int b, int c) {
		if(!(a<b) || (a+b)!=c) {
			return false;
		}
		
		if(radicals[a]*radicals[b]*radicals[c]>=c) {
			return false;
		}
		
		ArrayList<Integer> factors = BasicMath.distinctPrimeFactors(a);
		for(int n: BasicMath.distinctPrimeFactors(b)) {
			if(factors.contains(n)) {
				return false;
			} else {
				factors.add(n);
			}
		}
		for(int n: BasicMath.distinctPrimeFactors(c)) {
			if(factors.contains(n)) {
				return false;
			} else {
				factors.add(n);
			}
		}
		
		return true;
	}

}
