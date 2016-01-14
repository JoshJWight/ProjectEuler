package problem111_120;

import java.math.BigInteger;

public class Problem113 {

	public static BigInteger dMatrix[][];
	public static BigInteger iMatrix[][];
	
	public static void main(String[] args) {
		dMatrix = new BigInteger[101][10];
		iMatrix = new BigInteger[101][10];
		
		BigInteger sum = BigInteger.ZERO;
		for(int i=1; i<=100; i++) {
			BigInteger n = numNonBouncy(i);
			System.out.println(i + ": " + n);
			
			sum = sum.add(n);
			System.out.println("Total: " + sum);
			if(i<8) {
				System.out.println("Expected: " + expected((int)Math.pow(10, i)));
			}
		}
		System.out.println(sum);
	}
	
	public static int expected(int n) {
		int nNonBouncy = 0;
		for(int i=1; i<n; i++) {
			if(!Problem112.isBouncy(i)) {
				nNonBouncy++;
			}
		}
		return nNonBouncy;
	}
	
	public static BigInteger numNonBouncy(int length) {
		System.out.println();
		System.out.println("Length: " + length);
		System.out.println("Increasing: " + numIncreasing(length, 1));
		System.out.println("Decreasing: " + numDecreasing(length));
		System.out.println("Both: " + 9);
		
		return numIncreasing(length, 1).add(numDecreasing(length)).subtract(new BigInteger("9")); //subtract the number of numbers that are both increasing and decreasing
	}
	
	public static BigInteger numIncreasing(int length, int min) {
		if(iMatrix[length][min] !=null) {
			return iMatrix[length][min];
		}
		
		if(length==1) {
			return new BigInteger("" + (10-min));
		}
		BigInteger total = BigInteger.ZERO;
		for(int j=min; j<10; j++) {
			total = total.add(numIncreasing(length-1, j));
		}
		iMatrix[length][min] = total;
		return total;
	}
	
	//need this to account for 0 not being a valid start digit
	public static BigInteger numDecreasing(int length) {
		if(length==1) {
			return new BigInteger("9");
		}
		BigInteger total=BigInteger.ZERO;
		for(int i=1; i<10; i++) {
			total = total.add(numDecreasing(length-1, i));
		}
		return total;
	}
	
	public static BigInteger numDecreasing(int length, int max) {
		if(dMatrix[length][max] !=null) {
			return dMatrix[length][max];
		}
		
		if(length==1) {
			return new BigInteger("" + (max+1));
		}
		BigInteger total = BigInteger.ZERO;
		for(int j=0; j<=max; j++) {
			total = total.add(numDecreasing(length-1, j));
		}
		dMatrix[length][max] = total;
		return total;
	}

}
