package problem111_120;

public class Problem112 {

	public static void main(String[] args) {
		int n=1;
		int nBouncy = 0;
		while(true) {
			if(isBouncy(n)) {
				nBouncy++;
			}
			
			if((double)nBouncy/(double)n == .99) {
				break;
			}
			
			n++;
		}
		
		System.out.println(n);

	}
	
	public static boolean isBouncy(int i) {
		return !isIncreasing(i) && !isDecreasing(i);
	}
	
	public static boolean isIncreasing(int i) {
		String s = "" + i;
		for(int j=0; j<s.length()-1; j++) {
			int n1 = Integer.valueOf(s.substring(j, j+1));
			int n2 = Integer.valueOf(s.substring(j+1, j+2));
			if(n1>n2) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isDecreasing(int i) {
		String s = "" + i;
		for(int j=0; j<s.length()-1; j++) {
			int n1 = Integer.valueOf(s.substring(j, j+1));
			int n2 = Integer.valueOf(s.substring(j+1, j+2));
			if(n1<n2) {
				return false;
			}
		}
		return true;
	}
}
