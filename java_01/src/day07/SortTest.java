package day07;

import java.util.Arrays;

import util.Sort;

public class SortTest {

	public static void main(String[] args) {
		
		int[] src = {10,20,5,2,100,7};
		
		int[] result = Sort.sort(src);
		
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(result));
	}
}
