package problem071_080;

import euler.util.GCF;

/**
 * Problem73.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * @author Pharaun
 *
 */
public class Problem73 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 0;
		
		for(int d = 2; d<=12000; d++) {
			System.out.println(d);
			for(int n=(d/3)+1; (2*n)<d; n++) {
				
				boolean valid = true;
				
				//if a fraction is reducible, we already saw it
				for(int f=2; f<=n; f++) {
					if(n%f==0 && d%f==0) {
						valid=false;
						break;
					}
				}
				if(valid) {
					num++;
				}				
			}
		}
		System.out.println(num);
	}

}
