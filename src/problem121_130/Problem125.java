package problem121_130;

import java.util.ArrayList;

import euler.util.Strings;

public class Problem125 {

	public static long cache[][];//sum of squares from r^2 to c^2
	
	public static void main(String[] args) {
		cache = new long[10000][10000];
		
		long total = 0;
		
		ArrayList<Long> nums = new ArrayList<Long>();
		
		for(int i=2; i<10000; i++) {
			for(int j=1; j<i; j++) {
				long s = sum(j, i);
				if(Strings.isPalindrome(s + "") && s<Math.pow(10, 8)) {
					System.out.println(j + "-" + i + ": " + s);
					if(!nums.contains(s)) {
						nums.add(s);
					}
					else {
						System.out.println("Duplicate!");
					}
				}
			}
		}
		
		for(Long n: nums) {
			total += n;
		}
		
		System.out.println(total);

	}
	
	public static long sum(int i, int j) {
		if(i>j) {
			System.out.println("inputs " + i + ", " + j);
		}
		if(i==j) {
			return (long)i*(long)i;
		}
		if(cache[i][j]>0) {
			return cache[i][j];
		}
		
		long sum = sum(i, j-1) + (long)j*(long)j;
		cache[i][j] = sum;
		return sum;
	}

	

}
