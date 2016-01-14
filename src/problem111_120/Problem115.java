package problem111_120;

public class Problem115 {
public static long cache[];
	
	public static final int M = 50;

	public static void main(String[] args) {
		for(int n=1;;n++) {
			cache = new long[n+1];
			long f = getB(n);
			System.out.println(n + ": " + f);
			if(f>1000000) {
				break;
			}
		}
		
		
	}
	
	//number of ways to fill a space of n units preceded by a black block
	public static long getB(int n) {
		if(n==0) {
			return 1;
		}
		if(cache[n]>0) {
			return cache[n];
		}
		long sum = getB(n-1);//add either a black block or a red block
		for(int i=M; i<=n; i++) {
			sum+=getR(n-i);
		}
		cache[n]=sum;
		return sum;
		
	}
	//number of ways to fill a space of n units preceded by a red block
	public static long getR(int n) {
		if(n==0) {
			return 1;
		}
		return getB(n-1);
	}
}
