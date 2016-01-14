package problem021_030;

public class Problem26 {
	public static void main(String args[]) throws Exception {
		int max =-1;
		int maxl =0;
		
		for(int i=1; i<1000; i++) {
			String f = unitFraction(i);
			System.out.println(i + ": " + (f.length()>200 ? f.substring(0, 200) + "..." : f));
			String c = cycle(f);
			int len = c.length();
			if(len>maxl) {
				max = i;
				maxl = len;
			}
			System.out.println(i + ": (" + len + ")" + c);
		}
		
		System.out.println("max: " + max + "(" + maxl + ")"); 
	}
	
	public static String unitFraction(int d) {
		String result = "0.";
		
		int r = 1;
		for(int j=0; j<7000; j++) {
			r *= 10;
			int n = r/d;
			result +=n;
			r -= d*n;
			
			if(r==0) {
				break;
			}
		}
		
		return result;
	}
	
	public static String cycle(String s) throws Exception {
		if(s.length()<100) {
			return "";
		}
		for(int i=1; i<5000; i++) {
			String s1 = s.substring(200, 200+i);
			for(int j=1; j<5; j++) {
				String s2 = s.substring(200+(j*i), 200+(j*i)+i);
				if(!s2.equals(s1)) {
					break;
				}
				if(j==4) {
					return s1;
				}
			}
		}
		
		throw new Exception("No cycle found in " + s);
	}
}


