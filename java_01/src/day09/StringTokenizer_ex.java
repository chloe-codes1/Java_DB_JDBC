package day09;

import java.util.StringTokenizer;

public class StringTokenizer_ex {


	// 책 191p
		
	// [ StringTokenizer Class ]
	
		StringTokenizer st;
		
		
		//현재 인자로 전달된 String객체인 str을 기본 구분문자인 white space, new line, tab 등의 구분문자로 하여 분할할 StringTokenizer 객체 생성
		public StringTokenizer_ex (String str) {
			System.out.printf("str : %s%n",str);
			st = new StringTokenizer(str);
		}
		
		//현재 인자로 전달된 String 객체인 str을 두 번째 인자인 delim을 구분문자로 하여 분할할 StringTokenizer 생성
		public StringTokenizer_ex (String str, String delim) {
			System.out.printf("str : %s%n",str);
			st = new StringTokenizer(str, delim);
		
	}
		public void print() {
			
			
		// [.countTokens()]
			//
			
			System.out.printf("Token count : %s%n", st.countTokens());
			while(st.hasMoreTokens()) {
				String token = st.nextToken();
				System.out.println(token);
			}
			System.out.println("--------------------");
		}

		public static void main(String[] args) {
			
			StringTokenizer_ex st1 = new StringTokenizer_ex("Happy day");
			st1.print();
			
			StringTokenizer_ex st2 = new StringTokenizer_ex("2005/08/15","/");
			st2.print();
			
		}
		
}
