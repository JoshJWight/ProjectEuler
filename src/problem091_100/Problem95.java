package problem091_100;

import java.util.ArrayList;

public class Problem95 {
	public static int cache[];
	
	public static void main(String args[]) {
		cache = new int[1000001];
		int longest = 0;
		int result = 0;
		for(int i=2; i<=1000000; i++) {
			ArrayList<Integer> chain = new ArrayList<Integer>();
			chain.add(i);
			while(true) {
				int n = divisorSum(chain.get(chain.size()-1));
				if(n==i) {
					System.out.println(i + " - amicable chain of length " + chain.size());
					break;
				}
				if(n>1000000 || chain.contains(n)) {
					if(i==12496){System.out.println(i + " - terminated after " + chain.size());};
					chain.clear();
					break;
				}
				chain.add(n);
			}
			if(chain.size()>longest) {
				longest = chain.size();
				result = i;
			}
		}
		System.out.println(result);
	}
	public static int divisorSum(int n) {
		if(cache[n]>0) {
			return cache[n];
		}
		int sum = 0;
		for(int i=1; i*2<=n; i++) {
			if(n%i==0) {
				sum+=i;
			}
		}
		cache[n] = sum;
		return sum;
	}
}
