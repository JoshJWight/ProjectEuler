package problem091_100;

public class Problem94 {

	public static void main(String[] args) {
		long sum = 0;
		for(long i=3; i<340000000; i++) {
						
			if(i*3-1 <= 1000000000 && integerArea(i, i-1)) {
				System.out.println(i + ", " + i + ", " + (i-1));
				sum+= i*3-1;
			}
			if(i*3+1 <= 1000000000 && integerArea(i, i+1)) {
				System.out.println(i + ", " + i + ", " + (i+1));
				sum+= i*3+1;
			}
		}
		System.out.println(sum);
	}
	
	public static boolean integerArea(long i, long j) {
		if(j%2==1) {
			return false;
		}
		long square = i*i - (j*j/4);
		
		if(square<0) {
			System.out.println(i + ", " + i + ", " + (j) + " gives bogus result");
			System.exit(0);
		}
		
		long sqrt = (long) (Math.sqrt(square) + 0.5);
		return sqrt*sqrt == square;
		
		/*double area = j * Math.sqrt(i*i - (j*j/4)) / 2;
		
		if(Math.floor(area)==area && j%2==1) {
			System.out.println(i + ", " + i + ", " + (j) + " gives bogus result");
			System.exit(0);
		}
		
		return Math.floor(area)==area;*/
	}

}
