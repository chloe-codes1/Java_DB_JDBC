package util;

import java.util.Arrays;

public class MyUtil {
	
		public static long add(int a, int b) { //public을 넣어야만 다른 패키지에 있는 MyMathTest에서 사용 가능!
			return a+b;
		}
		
		public static double add(double a, double b) {
			
			return a+b;
		}
		
		public static double add(double a, double b, double c) {
			return a+b+c;
		}
		
 		public static double add(double...nums) {
 			
 			double sum=0; 
 			for (double data :nums ) {
 				sum+=data;
 			}
 			return sum;
 		}
 		
 		
 	// [ leftPad ]	
 		
 		public static String leftPad(String str, int size, char padChar) {
 			//instance method
 			// -> new로 memory에 올려야지 사용 가능 
 			
 			if(str.length() > size) {
 				return str;
 			}
 			int count = str.length();
 			for(int i=0 ;i<size-count ;i++) {
 				str = padChar + str;
 			}
 				return str;
 		}

 		
 	// [ rightPad ]	
 		
 		public static String rightPad(String str, int size, char padChar) {
 		
 			if(str.length() > size) {
 				return str;
 			}
 			int count = str.length();
 			for(int i=0 ; i <size - count ; i++) {
 				
 				str=str + padChar;
 			}
 				return str;
 		}
 		
 		
 	// [ Sort ]
 		
 		public static int[] sort(int[] nums) { // int type의 배열을 받아서 int type 배열을 return 하겠다

 			// 배열 원본은 변경이 되지 않도록 하고
 			// 오름차순으로 정렬된 int[]를 리턴한다.
 				
 				int[] copy = new int[nums.length]; // 새로운 배열 만들어서
 								//원본과 크기 똑같게 만듬
 				System.arraycopy(nums, 0, copy, 0, nums.length); // 복사해놓음 -> 원본을 보존하기 위해! (주소 공유하지 않도록!)

 				//복사본 Int[] a를 sort함
 				
 				int count = 0;
 				//정렬 알고리즘
 				for (int i = 0; i < copy.length - 1; i++) {
 					int min = i;
 					for (int j = i + 1; j < copy.length; j++) {
 						if (copy[min] > copy[j]) {
 							min = j;
 						}
 					}
 					if (i != min) {

 						int temp = copy[i];
 						copy[i] = copy[min];
 						copy[min] = temp;
 						count++;
 					}
 				}
 				return copy;
 			}
 		
 	
 	// [ max ]
 	// -> 숫자를 넘겨받아 그 중 가장 큰 수를 리턴하는 함수 
 		
 		public static int max(int...nums) {
 			//util과 heap에 있는 data 사용하지 않으므로 Static 처리 가능
 					
 			int max=Integer.MIN_VALUE;
 			//0이 아니라 임의의 아주 작은 값을 초기값으로 넣음 (int 값 즁 가장 작은 값) 
 			//=> Integer.MIN_VALUE (경계치의 데이터)
 			//==> 이들을 확인해야 오류를 잡을 수 있음
 				//-> Wrapper Class 사용함
 			
 			for (int data : nums) {
 					if (max < data)
 						max = data;
 			}
 			return max;
 		}
 		
 		
 	// [ min ]
 	// -> 숫자를 넘겨받아 그 중 가장 작은 수를 리턴하는 함수 
 		
 		public static int min(int...nums) {
 					
 			int min=Integer.MAX_VALUE;
 			//0이 아니라 임의의 아주 큰 값을 초기값으로 넣음 (int 값 즁 가장 큰 값) => Integer.MAX_VALUE
 			for (int data : nums) {
 					if (min > data)
 						min = data;
 			}
 			return min;
 		}
 	}	