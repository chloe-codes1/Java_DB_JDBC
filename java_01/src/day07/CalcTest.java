package day07;

public class CalcTest {

	public static void main(String[] args) {
		
		/*
		Calc c1 = new Calc();
		Calc c2 = new Calc();
		Calc c3 = new Calc();
		Calc c4 = new Calc();

		System.out.println(c1.add(11, 99));
		System.out.println(c2.add(11, 99));
		System.out.println(c3.add(11, 99));
		System.out.println(c4.add(11, 99));
		*/
			//-> 이렇게 하면 같은 코드를 반복해서 사용하게 됨
			//=> 비효율적!!!
		
		//그래서 Calc에 있는 add함수를 제외한 takeaway 등등의 함수들을 static 처리함
		//-> static 처리하면 memory에 올라가므로 class name으로 접근 가능
		//-> 그러면 아래와 같이 출력 가능!
		
		Calc c1 = new Calc();  // stack 영역으로 올라감 -> heap영역의 add()를 reference함
		
		//instance method -> 주소로 접근
		System.out.println(c1.add(11, 99)); 
		
		// class method -> class name으로 접근
		System.out.println(Calc.takeaway(11, 99)); 
		System.out.println(Calc.multiple(11, 99));
		System.out.println(Calc.divide(11, 9));
	}
}
