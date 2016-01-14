package problem071_080;

/**
 * @author Pharaun
 *
 */
public class Problem75 {
	public static void main(String args[]) {
		int n = 0;
		for(long i = 4; i<=1500000L; i+=2) {
			int s = 0;
			for(long a = 1; a<i/(2.0+Math.sqrt(2)) ; a++) {
				long x = i - a;
				long x1 = a*a + x*x;
				if(x1%(2*x)==0) {//can form right triangle
					long c = x1/(2*x);
					long b = x-c;
					if(a*a + b*b == c*c) {
						s++;
						if(s>1) {
							break;
						}
					}
					
				}
			}
			if(s==1) {
				System.out.println(i);
				n++;
			} else {
				//System.out.println(i + ": " + s);
			}
		}
		System.out.println("total: " + n);
	}
}
