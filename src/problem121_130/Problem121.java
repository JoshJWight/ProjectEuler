package problem121_130;

public class Problem121 {
	//simulating the game in reverse to allow caching
	public static double cache[][];//probability of getting at least r disks with c rounds remaining
	public static void main(String args[]) {
		cache = new double[9][16];
		double p = p(8, 15);
		System.out.println(Math.floor(1.0/p));
	}
	
	public static double p(int r, int c) {
		if(r==0) {
			return 1;
		}
		if(c==0) {
			return 0;
		}
		
		if(cache[r][c] != 0) {
			return cache[r][c];
		}
		
		double sum = (1.0/(double)(c+1) * p(r-1, c-1)) + (double)c/(double)(c+1) * p(r, c-1);
		cache[r][c] = sum;
		return sum;		
	}
}
