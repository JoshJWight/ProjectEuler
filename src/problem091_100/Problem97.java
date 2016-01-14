package problem091_100;

public class Problem97 {

	public static void main(String[] args) {
		long num = 1;
		long mod = (long)100000*(long)100000;//to mod the num to the last 10 digits
		System.out.println(mod);
		for(long i=0; i<7830457; i++) {
			num = (num*2) % mod;
		}
		
		num = (num * 28433 + 1) % (mod);
		System.out.println(num);
	}

}
