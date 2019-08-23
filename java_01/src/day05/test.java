package day05;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		String str = "Hi Java";

		// get char at specific index
		char c = str.charAt(0);

		// Character array from String
		char[] charArray = str.toCharArray();

		System.out.println(str + " String index 0 character = " + c);
		System.out.println(str + " String converted to character array = " + Arrays.toString(charArray));

	}



	
	
	
}
