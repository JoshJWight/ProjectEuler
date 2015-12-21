package problem011_020;
/**
 * Problem19.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * @author Josh Wight
 *
 */
public class Problem19 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int day = 1;// tues
		int year = 1901;
		int count = 0;

		while (year < 2001) {
			for (int mon = 1; mon <= 12; mon++) {
				if (day == 6) {
					count++;
				}

				if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
					day = (day + 31) % 7;
				} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
					day = (day + 30) % 7;
				} else {
					if (year % 4 == 0) {
						day = (day + 29) % 7;
					} else {
						day = (day + 28) % 7;
					}
				}
			}
			year++;
		}
		System.out.println("" + count);
	}

}
