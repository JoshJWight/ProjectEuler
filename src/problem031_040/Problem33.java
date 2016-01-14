package problem031_040;

public class Problem33 {

	public static void main(String[] args) {
		for(int n=11; n<99; n++) {
			for(int d=n+1; d<100; d++) {
				double r1 = (double)n / (double)d;
				double r2 = Double.valueOf(("" + n).substring(0, 1)) / Double.valueOf(("" + d).substring(1, 2));
				double r3 = Double.valueOf(("" + n).substring(1, 2)) / Double.valueOf(("" + d).substring(0, 1));
				if((r1==r2 || r1==r3)&&n%11!=0) {
					System.out.println(n + "/" + d);
				}
			}
		}

	}

}
