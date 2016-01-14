package euler.util;

public class Printing {
	public static void printIntArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if(i<arr.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
}
