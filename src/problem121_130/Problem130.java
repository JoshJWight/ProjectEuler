package problem121_130;

import euler.util.BasicMath;

public class Problem130 {
	public static void main(String[] args) {
		long n = 2;
		int num = 0;
		long sum = 0;
		while(true) {
			if(n%2!=0 && n%5!=0 && !BasicMath.isPrime(n)) {
				int a = a(n);
				
				if((n-1) % a == 0) {
					System.out.println(n);
					sum+=n;
					num++;
				}
				
				if(num==25) {
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
			//System.out.println("a");
			repunit = repunit*10 + 1;
			a++;
		}
		
		long r = repunit%n;
		while(r!=0) {
			//System.out.println("b n=" + n);
			r = r*10 + 1;
			a++;
			r = r%n;
		}
		
		return a;
	}
}

