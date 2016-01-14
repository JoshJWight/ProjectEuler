package problem111_120;

import java.util.ArrayList;

public class Problem116 {

	private static long rArr[];
	private static long gArr[];
	private static long bArr[];
	
	public static void main(String[] args) {
		rArr = new long[51];
		gArr = new long[51];
		bArr = new long[51];
		
		long nr = numR(50) - 1; //leave out the permutation that is an unbroken row of black tiles
		long ng = numG(50) - 1;
		long nb = numB(50) - 1;
		
		printArr(rArr);
		printArr(gArr);
		printArr(bArr);
		
		System.out.println("r: " + nr + ", g: " + ng + ", b: " + nb);
		System.out.println("total: " + (nr+ng+nb));
	}
	
	public static void printArr(long a[]) {
		for(long l: a) {
			System.out.print(l + ", ");
		}
		System.out.println();
	}
	
	public static long numR(int len) {
		if(len<0) {
			return 0;
		}
		if(len==0) {
			return 1; 
		}		
		if(rArr[len]!=0) {
			return rArr[len];
		}
		
		long n = numR(len-2) + numR(len-1);
		rArr[len] = n;
		
		return n;
	}
	
	public static long numG(int len) {
		if(len<0) {
			return 0;
		}
		if(len==0) {
			return 1; 
		}		
		if(gArr[len]!=0) {
			return gArr[len];
		}
		
		long n = numG(len-3) + numG(len-1);
		gArr[len] = n;
		
		return n;
	}
	
	public static long numB(int len) {
		if(len<0) {
			return 0;
		}
		if(len==0) {
			return 1; 
		}		
		if(bArr[len]!=0) {
			return bArr[len];
		}
		
		long n = numB(len-4) + numB(len-1);
		bArr[len] = n;
		
		return n;
	}

}
