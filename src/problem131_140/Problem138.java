package problem131_140;

public class Problem138 {

	public static void main(String[] args) {
		long n = 1;
		long sum = 0;
		long num = 0;
		while(true) {
			for(long b=2; b<n*2; b+=2) {
				double h = Math.sqrt(n*n-(b/2)*(b/2));
				if(h==b+1 || h==b-1) {
					sum += n;
					num++;
					System.out.println(n + ", " + b);
				}
				if(num==12) {
					break;
				}
			}			
			if(num==12) {
				break;
			}
			n++;
		}
		System.out.println(sum);
	}

}
