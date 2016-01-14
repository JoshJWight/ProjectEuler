package problem081_090;

import java.util.ArrayList;
import java.util.HashMap;

import euler.util.BasicMath;

public class Problem87 {

	public static final long MAX = 50000000;
	
	public static void main(String[] args) {
		ArrayList<Long> primes = new ArrayList<Long>();
		HashMap<Long,String> nums = new HashMap<Long,String>();
		
		for(long i=2;i<Math.sqrt(MAX);i++) {
			if(BasicMath.isPrime(i)) {
				primes.add(i);
			}
		}
		System.out.println(primes.size() + " primes");
		
		for(int s=0; s<primes.size(); s++) {
			System.out.println("s=" + s);
			long square = (long)Math.pow(primes.get(s), 2);
			for(int c=0; c<primes.size(); c++) {
				long cube = (long)Math.pow(primes.get(c), 3);
				if(cube>MAX){break;}
				for(int f=0; f<primes.size(); f++) {
					long fourth = (long)Math.pow(primes.get(f), 4);
					if(fourth>MAX){break;}
					
					long sum = square + cube + fourth;
					if(sum<=MAX && nums.get(sum)==null) {
						nums.put(sum, "");
					}
				}
			}
		}
		System.out.println(nums.size());
	}

}
