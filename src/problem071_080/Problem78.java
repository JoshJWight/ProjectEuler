package problem071_080;

import java.math.BigInteger;

public class Problem78 {
	public static BigInteger cache[][];
	public static void main(String[] args) {
		int i = 1;
		cache = new BigInteger[10000][10000];
		while(true) {
			//expandCache(i+1);
			BigInteger p = p(i, i);
			System.out.println("p(" + i + ") = " + p);
			if(p.mod(new BigInteger("1000000")).equals(BigInteger.ZERO)) {
				System.out.println(p);
				break;
			}
			i++;
		}

	}
	public static void expandCache(int size) {
		BigInteger old [][] = cache;
		cache = new BigInteger[size][size];
		for(int i=0; i<old.length; i++) {
			for(int j=0; j<old.length; j++) {
				cache[i][j] = old[i][j];
			}
		}
	}
	
	public static BigInteger p(int n, int max) {
		max = Math.min(max, n);
		if(n==0) {
			return BigInteger.ONE;
		}
		if(cache[n][max]!=null) {
			return cache[n][max];
		}
		BigInteger sum = BigInteger.ZERO;
		for(int i=1; i<=max; i++) {
			sum = sum.add(p(n-i, i));
		}
		cache[n][max] = sum;
		return sum;
	}
	
	

}
