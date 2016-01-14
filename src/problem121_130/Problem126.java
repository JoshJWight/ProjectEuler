package problem121_130;

public class Problem126 {

	public static void main(String[] args) {
		for(int i=1; i<=4; i++) {
			System.out.println(numCubes(3, 2, 1, i));
		}

	}
	
	public static long numCubes(long w, long l, long h, long layer) {
		long total = 0;
		total += (2*w*l) +  (2*w*h) + (2*l*h);
		
		if(layer>=2) {
			total += (w + l + h) * (4*(layer-1));
		}
		
		if(layer>=3) {
			total += 8 * ((layer-2)*(layer-1)/2);
		}
		return total;
	}

}
