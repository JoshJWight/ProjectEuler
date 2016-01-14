package problem111_120;

import euler.util.BasicMath;
import euler.util.Printing;

public class Problem111 {

	public static void main(String[] args) {		
		long sum = 0;
		for(int i=0; i<10; i++) {
			for(int j=9; j>0; j--) {
				long s = s(10, i, j);
				if(s!=0) {
					sum += s;
					System.out.println("M(10, " + i + ") = " + j);
					System.out.println("S(10, " + i + ") = " + s);
					break;
				}
			}
		}
		System.out.println(sum);
	}
	
	/**
	 * 
	 * @param n number of digits
	 * @param d repeated digit
	 * @param m number of times digit is repeated
	 * @return
	 */
	public static long s(int n, int d, int m) {
		long sum = 0;
		
		String run = "";
		for(int i=0; i<m; i++) {
			run += d;
		}
		
		int arr[] = initArr(n-m);
		
		//i=number of digits that are before the run
		do {
			//j = rest of digits
			for(long j=0; j<Math.pow(10, n-m); j++) {
				String s1 = pad(j, n-m);
				
				String s = run;
				for(int i=0; i<arr.length; i++) {
					int a = arr[i];
					if(a==s.length()) {
						s = s + s1.substring(i, i+1);
					} else {
						s = s.substring(0, a) + s1.substring(i, i+1) + s.substring(a);
					}
				}
				
				long k = Long.valueOf(s);
				if(!s.startsWith("0") && BasicMath.isPrime(k)) {
					System.out.println(s);
					sum+=k;
				}
			}
		} while(iterate(arr, 10));
		
		return sum;
	}
	
	public static String pad(long n, int len) {
		String s = "" + n;
		while(s.length()<len) {
			s = "0" + s;
		}
		return s;
	}
	public static int[] initArr(int len) {
		int arr[] = new int[len];
		for(int i=0; i<len; i++) {
			arr[i] = i;
		}
		return arr;
	}
	
	public static boolean iterate(int [] arr, int max) {
		if(arr[0]==max-arr.length) {
			return false;
		}
		
		for(int i=arr.length-1 ;i>=0; i--) {
			if(arr[i]<max-arr.length+i) {
				int n = arr[i];
				for(int j=i; j<arr.length; j++) {
					n++;
					arr[j] = n;
				}
				break;
			}
		}
		
		return true;
	}

}
