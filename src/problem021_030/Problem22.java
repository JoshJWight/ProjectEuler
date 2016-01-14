package problem021_030;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem22 {

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader("names.txt"));
		String content = br.readLine();
		br.close();
		
		ArrayList<String> names = new ArrayList<String>();
		
		for(String s: content.split(",")){
			s = s.replace("\"", "");
			for(int i=0; i<=names.size(); i++) {
				if(i==names.size()) {
					names.add(s);
					break;
				}
				if(s.compareTo(names.get(i))<0) {
					names.add(i, s);
					break;
				}
			}
		}
		
		long total = 0;
		
		for(int i=0; i<names.size(); i++) {
			String name = names.get(i);
			int s1 = 0;
			for(int j = 0; j<name.length(); j++) {
				char c = name.charAt(j);
				s1 += c - 'A' + 1;
			}
			int s2 = s1*(i+1);
			total +=s2;
			
			System.out.println(name + " - " + (i+1) + " * " + s1 + " = " + s2 + " (" + total + ")");
			
			
		}
		
		System.out.println();
		System.out.println(total);
	}

}
