package hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TwoStrings {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfInput = Integer.parseInt(br.readLine());
		int inputCounter = 0;
		String string1, string2;
		StringBuilder s = new StringBuilder();
		while(inputCounter<noOfInput){
			string1 = br.readLine();
			string2 = br.readLine();
			if(inputCounter == noOfInput - 1 )
				s.append(isSubstring(string1, string2));
			else
				s.append(isSubstring(string1, string2)).append("\n");
			++inputCounter;
		}
		System.out.println(s);
	}
	
	public static String isSubstring(String s1, String s2){
		boolean isSubstring = false;
		HashSet<Character> characters = new HashSet<Character>();
		HashSet<Character> characters1 = new HashSet<Character>();
		char[] arr = s1.toCharArray();
		for (char c : arr) {
			characters.add(c);
		}
		arr = s2.toCharArray();
		for (char c : arr) {
			characters1.add(c);
		}
		for (char c : characters) {
			if(!characters1.add(c)){
				isSubstring = true;
				break;
			}
		}
		return isSubstring?"YES":"NO";
	}
}
