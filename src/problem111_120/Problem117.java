package problem111_120;

public class Problem117 {
	private static long arr[];
	
	public static void main(String[] args) {
		arr = new long[51];
		arr[0] = 1;
		long n = numRGB(50);
		
		printArr(arr);
		
		System.out.println("total: " + (n));
	}
	
	public static void printArr(long a[]) {
		for(long l: a) {
			System.out.print(l + ", ");
		}
		System.out.println();
	}
	
	public static long numRGB(int len) {
		if(len<0) {
			return 0;
		}	
		if(arr[len]!=0) {
			return arr[len];
		}
		
		long n = numRGB(len-4) + numRGB(len-3) + numRGB(len-2) + numRGB(len-1);
		arr[len] = n;
		
		return n;
	}
}
