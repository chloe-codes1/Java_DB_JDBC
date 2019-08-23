package day15_ex;

//일반적인 import 구문
import util.MyUtil;

//static import 구문
import static util.MyUtil.add;
  // [ Static import 구문 ]
  // -> static method, static variable에만 사용 가능하며,
  //    이렇게 함으로써 class name인 MyUtil 쓰지 않고, add만 입력하면 호출 가능하다

		// [ Class Path 설정하기 ]
		// -> library로 다른 패키지 class 가져와서 쓰기 
		//다른 package에 있는 util.MyUtil 사용하기 위해 .jar파일로 만들어서 class path 설정함

public class Test01 {

	public static void main(String[] args) {

		
	
		MyUtil u = new MyUtil();
		
		String s = u.leftPad("c", 3, '*'); //instance 데려와서 method 사용할 때
		System.out.println(s);
		
		System.out.println(util.MyUtil.rightPad("java", 10, '#')); //static method 사용할 때
		
		
		//add() method를 static import 했기 때문에 add만 쓰면 된다
		System.out.println(add(1,2,3,4,5));
		
	}

}
