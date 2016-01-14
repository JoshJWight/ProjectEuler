package problem101_110;

public class Problem108 {

	public static void main(String[] args) {
		for(long n=4;;n++) {
			int s = nSolutions(n);
			System.out.println(n + ": " + s + " solutions");
			if(s>1000) {
				System.out.println(n);
				break;
			}
		}

	}

	public static int nSolutions(long n) {
		int s = 0;
		for(long x=n+1; x<=n*2; x++) {
			if((x*n) % (x-n) == 0) {
				s++;
			}
		}
		return s;
	}
}
