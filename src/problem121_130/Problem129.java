package problem121_130;

public class Problem129 {

	public static void main(String[] args) {
		long n = 1000000;
		int max = 0;
		long nmax = 0;
		while(true) {
			int a = a(n);
			if(a>max) {
				max = a;
				nmax = n;
				System.out.println("A(" + n + ") = " + a);
			}
			if(a>1000000) {
				break;
			}
			
			n++;
		}
		System.out.println(nmax);
	}
	
	public static int a(long n) {
		if(n%2==0 || n%5==0) {
			return 0;
		}
		
		long repunit = 11;
		int a = 2;
		while(repunit<n) {
			//System.out.println("a");
			repunit = repunit*10 + 1;
			a++;
		}
		
		long r = repunit%n;
		while(r!=0) {
			//System.out.println("b n=" + n);
			r = r*10 + 1;
			a++;
			r = r%n;
		}
		
		return a;
	}

}
