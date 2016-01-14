package euler.util;

import java.util.ArrayList;

public class BasicMath {
	public static boolean isPerfectSquare(long l) {
		long sqrt = (long) (Math.sqrt(l) + 0.5);
		return sqrt*sqrt == l;
	}
	
	public static boolean isPrime(long num) {
		if (num <= 1) {
			return false;
		}
		for (double a = 2; a <= Math.sqrt(num); a++) {
			if (num % a == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<Integer> distinctPrimeFactors(int n) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int m = n;
		for(int i=2; (i<=Math.sqrt(n)) && i<m; i++) {
			if(m%i==0) {
				factors.add(i);
				while(m%i==0) {
					m = m/i;
				}
			}
		}
		
		if(m>1) {
			factors.add(m);
		}
		
		return factors;
	}
	
	public static long radical(int n) {
		long product = 1;
		for(int i: distinctPrimeFactors(n)) {
			product *=i;
		}
		return product;
	}
}
