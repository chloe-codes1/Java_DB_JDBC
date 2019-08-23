package exercises;

import java.util.StringTokenizer;

public class Test_StringTokenizer {

	public static void main(String[] args) {

		// [문제]
		// 홍** 이** 김** 박* -> 이렇게 출력하시오

		String names = "홍길동 / 이순신/김유신 /박철 ";

		// [ 내 원래 답 ]
		// -> 외자 이름인 박철을 박**으로 출력해서 문제임

//		StringTokenizer st1 = new StringTokenizer(names,"/");
//		
//		
//		for(int i = 0 ; i<= st1.countTokens()+2; i++) {
//			
//			System.out.print(st1.nextToken().trim().charAt(0) +"** ");
//			
//		}

		// [ 정답 ]
		StringTokenizer st = new StringTokenizer(names, "/");
		while (st.hasMoreTokens()) {

			String token = st.nextToken().trim();
			System.out.print(token.charAt(0));
			for (int i = 1; i < token.length(); i++) {
				System.out.print("*");
			}
			System.out.print(" ");

		}
	}
}
