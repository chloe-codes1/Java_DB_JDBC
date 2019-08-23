package day07;

public class book_p139 {

	// [ Call by Value ]
	//원본인 primitive는 변하지 않는다!
	
	public static int increase(int n) {//static method! -> class name으로 호출하면 됨!!!
								//여기서 인수 var1을 받아오는 int n이 매개변수!
								//-> var1은 복사되어 대입된다! (그래서 원본은 변하지 않음)
		++n;
		return n;
	}
	
	
	public static void main(String[] args) {
		int var1 = 100;
		System.out.println(var1);
		
		int var2 = book_p139.increase(var1);
					//static한 method (=class method) 호출함 -> class명.함수명 
					//var1은 인수
					//이 함수를 호출해서 var1의 값인 100이 인수로 들어감
		System.out.println(var1); //갔다와도 var1값은 안변함
		
		System.out.println(var1 + " " + var2);
	}
}
