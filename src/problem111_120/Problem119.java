package problem111_120;

import java.util.ArrayList;
import java.util.Collections;

public class Problem119 {

	public static void main(String[] args) {
		ArrayList<Long> nums = new ArrayList<Long>();
		for(int i=2; i<10000; i++) {
			for(int j=2; j<60; j++) {
				long n = (long)Math.pow(i, j);
				if(n>1000000000000000L) {
					break;
				}
				String s = n + "";
				int sum = 0;
				for(int k = 0; k<s.length(); k++) {
					sum += Integer.valueOf(s.substring(k, k+1));
				}
				if(s.length()>1 && sum==i) {
					nums.add(n);
					System.out.println(n + " = " + i + "^" + j);
				}
			}
		}
		Collections.sort(nums);
		System.out.println(nums.get(29));

	}

}
