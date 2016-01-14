package problem131_140;

import euler.util.BasicMath;

public class Problem133 {

	public static void main(String[] args) {
		long sum = 0;
		for(int n=2; n<100000; n++) {
			if(!BasicMath.isPrime(n)) {
				continue;
			}
			if(n==2 || n==5) {
				System.out.println(n);
				sum+=n;
				continue;
			}
			
			boolean flag = false;
			int a = a(n);
			for(int i: BasicMath.distinctPrimeFactors(a)) {
				if(i!=2 && i!=5) {
					flag=true;
					break;
				}
			}

			if(flag) {
				System.out.println(n);
				sum+=n;
			}
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
