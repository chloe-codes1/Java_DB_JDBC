package day05;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {
		
		
	// [ 배열 복사하기]
	// -> System.arraycopy
		
		
		// 배열 방 size 늘리기
		
		int[] scores = {77,99,100,85,91}; //5개의 공간을 referencing 하고 있음 => 5개의 자료만 저장 가능
		
		int[] sc = new int[scores.length*2]; //array scores의 2배 사이즈로 방을 만들어라  => +도 사용 가능!
		
		System.out.println(Arrays.toString(scores)); 
		System.out.println(Arrays.toString(sc));  //[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] => 10개의 공간 생성됨
														//기본형이라서 0으로 자동으로 초기화 됨
		
		
		// 배열 복사 (Array copy)
		System.arraycopy(scores, 0, sc, 0, scores.length);
			// System.arraycopy( )  => *** 배열 copy ***
			//-> 원본 배열, 원본배열의 어디부터, 복사 배열, 복사배열의 어디부터 복사, 원본배열의 어디까지 복사
		
		
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(sc)); // [77, 99, 100, 85, 91, 0, 0, 0, 0, 0]
												// => sc 배열의 맨 앞에 위치부터 5개에 scores 복사됨
		
		// String type Array의  Copy 예시
		String[] names = {"홍길동", "박길동", "고길동", "최길동"};
		
		String[] na = new String[names.length*2];
		
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(na)); //[null, null, null, null, null, null, null, null] => 8개의 공간 생성됨
														//String은 reference type이라 null값으로 초기화 됨
		
		System.arraycopy(names, 0, na, na.length-names.length, names.length); 
										//새로만든 na의 크기 - 원래 names의 크기 인 곳에 찍어라
		
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(na)); //[null, null, null, null, 홍길동, 박길동, 고길동, 최길동] 출력됨
		
		
		// Char type Array Copy 예시
		String me = "chloe";
		char[] character = me.toCharArray();
		
		char[] copy = new char[character.length+1];
		
		System.arraycopy(character, 0, copy, 1, character.length);
		
		System.out.println(Arrays.toString(character));
		System.out.println(Arrays.toString(copy));

	}
}
