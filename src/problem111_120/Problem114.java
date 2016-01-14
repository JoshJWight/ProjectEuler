package problem111_120;

public class Problem114 {

	public static long cache[];
	
	public static void main(String[] args) {
		cache = new long[51];
		System.out.println(getB(50));
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
		for(int i=3; i<=n; i++) {
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
