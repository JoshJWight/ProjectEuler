package problem091_100;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import euler.util.BasicMath;

public class Problem98 {

	public static void main(String[] args) throws IOException {
		String in[] = Files.readAllLines(Paths.get("p098_words.txt")).get(0).split(",");
		ArrayList<String> words = new ArrayList<String>();
		for(String s: in) {
			words.add(s.replaceAll("\"", ""));
		}
		
		long largest = 0;
		
		for(int i=0; i<words.size()-1; i++) {
			String s1 = words.get(i);
			for(int j=i+1; j<words.size(); j++) {
				String s2 = words.get(j);
				if(anagrams(s1, s2)) {
					System.out.println(s1 + ", " + s2);
					long sq = largestSquare(s1, s2);
					if(sq>largest) {
						largest = sq;
					}
				}
			}
		}
		System.out.println(largest);
	}
	
	public static boolean anagrams(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		for(int i=0; i<s1.length(); i++) {
			a1.add(s1.substring(i, i+1));
			a2.add(s2.substring(i, i+1));
		}
		Collections.sort(a1);
		Collections.sort(a2);
		return a1.equals(a2);
	}
	
	public static long largestSquare(String s1, String s2) {
		ArrayList<String> reduction = new ArrayList<String>();
		for(int i=0; i<s1.length(); i++) {
			String c = s1.substring(i, i+1);
			if(!reduction.contains(c)) {
				reduction.add(c);
			}
		}
		long largest = 0;
		for(long i=0; i<Math.pow(10, reduction.size()); i++) {
			String s = "" + i;
			if(s.length()<reduction.size()) {
				continue;
			}
			ArrayList<String> digits = new ArrayList<String>();
			boolean dupe = false;
			for(int j=0; j<s.length(); j++) {
				String n = s.substring(j, j+1);
				if(digits.contains(n)) {
					dupe=true;
					break;
				}
				digits.add(n);
			}
			if(!dupe) {
				HashMap<String, String> map = new HashMap<String, String>();
				for(int k=0; k<reduction.size(); k++) {
					map.put(reduction.get(k), digits.get(k));
				}
				
				String n1 = s1;
				String n2 = s2;
				
				for(int k=0; k<n1.length(); k++) {
					n1 = n1.substring(0, k) + map.get(n1.substring(k, k+1)) + n1.substring(k+1);
					n2 = n2.substring(0, k) + map.get(n2.substring(k, k+1)) + n2.substring(k+1);
				}
				if(n1.startsWith("0") || n2.startsWith("0")) {
					continue;
				}
				
				long l1 = Long.valueOf(n1);
				long l2 = Long.valueOf(n2);
				
				if(BasicMath.isPerfectSquare(l1) && BasicMath.isPerfectSquare(l2)) {
					System.out.println(n1 + ", " + n2);
					largest = Math.max(largest, Math.max(l1, l2));
				}
			}
		}
		return largest;
	}

}
