package day03;

public class Test02 {

	public static void main(String[] args) {
	
	// 조건 삼항 연산자
		
		int num = 99;
		System.out.println(num > 0 ? "양수" : "음수"); //양수
		
		System.out.println("-----------------");
		
		
	//양수 or 0 or 음수  -> 3가지 비교하기  => 삼항 연산자 두번 쓰기
		int num1 = 0;
		
		//내 답
		System.out.println(num1 == 0 ? "0": num1 > 0 ? "양수" : "음수"); 
		
		//선생님 답
		System.out.println(num1 > 0 ? "양수" : (num1==0 ? "0" : "음수"));
		
		
		String result = num1 > 0 ? "양수" : (num1==0 ? "0" : "음수");
		System.out.println(num1 + " : " + result);
		
	}
}
