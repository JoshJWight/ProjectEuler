package problem041_050;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem42.java 
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
public class Problem42 {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("words.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String doc = br.readLine();
			String[] arr = doc.split(",");
			words.addAll(Arrays.asList(arr));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < words.size(); i++)// remove quote marks
		{
			String word = words.get(i);
			words.set(i, word.substring(1, word.length() - 1));
		}

		int num = 0;
		for (String word : words) {
			if (check(word)) {
				num++;
			}
		}
		System.out.println(num + "");

	}

	public static boolean check(String word) {
		int num = 0;
		for (int i = 0; i < word.length(); i++) {
			num += word.charAt(i) - 'A' + 1;
		}
		int i = 1;
		while (true) {
			int tri = (i * (i + 1)) / 2;
			if (tri == num) {
				return true;
			} else if (tri > num) {
				return false;
			}
			i++;
		}

	}

}
