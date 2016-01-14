package euler.util;

public class Strings {
	public static String reverse(String s) {
		String r = "";
		for(int i=0; i<s.length(); i++) {
			r = s.substring(i, i+1) + r;
		}
		return r;
	}
	
	public static boolean isPalindrome(String s) {
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
}
