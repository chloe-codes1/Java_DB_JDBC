package day02_ex;

public class book_exercise2 {

	public static void main(String[] args) {
	
//교재 84p
		
	//#2
		/*
		int a =10;
		int b =20;
		System.out.println(++a);
		
		System.out.println(++a + b++);
		
		System.out.println((++a%3) + (a*++b));
		*/
		
	//#3
		int a,b;
		a = b = 10;  //=으로 되어있으면 오른쪽부터 시작해서 대입  -> 10을 b에 대입, b에 있는 10을 a에 대입
		
		boolean c = ++a > b++ || a++ >=++b;  //or는 둘 중 하나라도 참이면 참 -> 앞에가 참이므로 바로 true!! => 그래서 뒤에는 수행 하지 않음!
		
		System.out.println(a+ "," + b); // 뒤에는 수행하지 않았기 때문에 a와 b모두 11이다
		System.out.println("변수 c의 값 : " + c); // true!
		
	}

}
