package problem131_140;

import euler.util.BasicMath;

public class Problem132 {
	public static void main(String args[]) {
		long sum = 0;
		int num = 0;
		long n = 2;
		while(true) {
			if(n%2!=0 && n%5!=0 && BasicMath.isPrime(n)) {
				int a = a(n);
				
				boolean flag = true;
				for(int i: BasicMath.distinctPrimeFactors(a)) {
					if(i!=2 && i!=5) {
						flag=false;
						break;
					}
				}
				
				if(flag && (a%1024==0)) {
					flag = false;
					System.out.println("A(" + n + ") = " + a + " PUNKED!");
				}
				
				if(flag) {
					System.out.println("A(" + n + ") = " + a);
					sum+=n;
					num++;
				}
				
				if(num==40) {
					break;
				}
			}
			n++;
		}
		System.out.println(sum);
	}
	
	public static int a(long n) {
		if(n%2==0 || n%5==0) {
			return 0;
		}
		
		long repunit = 11;
		int a = 2;
		while(repunit<n) {
			repunit = repunit*10 + 1;
			a++;
		}
		
		long r = repunit%n;
		while(r!=0) {
			r = r*10 + 1;
			a++;
			r = r%n;
		}
		
		return a;
	}
}
