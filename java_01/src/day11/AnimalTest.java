package day11;

import day10.Animal;
import day10.Dog;

public class AnimalTest {

	public static void main(String[] args) {

		//Dog d = new Dog("진돗개", "쫑이");
		Animal d = new Dog("진돗개", "쫑이");
		
		//Down-casting을 하기 전에는 무조건!!! instanceof 쓰기!
		
		//instanceof 안쓰면 이렇게 됨
		Dog dd = (Dog) d;
		//Fish ff = (Fish) d;  
			//=> 이렇게 d는 Dog type인데 Fish type이라고 casting 하려고 하는데 (말도 안되는데) 에러 안남! 컴파일 때문에 못잡아줌!
			//=> 실행 시키면 시스템 죽음  ===> instanceof 꼭 써라~~~
		
		if(d instanceof Dog)((Dog)d).print();
		d.breath();
		
		//Fish f = new Fish("구피");
		Animal f = new Fish("구피");
		if(f instanceof Fish)((Fish)f).print();
		
		((Fish)f).breath(); 
			//이건 Fish type으로 down-casting해서 자식영역에 있는 breath() 이용하는거라서 당연히 '아가미~~'출력됨!
		
		f.breath(); 
			//이건 Animal type이라 원래 '폐~~' 출력되야 하는데 '아가미~~' 출력됨
			//-> why? Overriding 때문에 자식영역에 있는 breath() 가 호출되었기 때문!
		
		//물고기는 숨 안쉬는데 "폐로 숨쉰다~!"가 출력됨
		//-> 부모에게 물려받았으나 자식에게 적합하지 않은 data가 출력됨
		//-> 걸러줘야함!
		//=> *** Method OverRiding ***
		
	//(f의 data type을 Animal로 바꾸었음)
		//+ f의 data type이 부모영역인 Animal인데도 자식영역인 Fish Class에 있는 breath() method 가 출력됨
		//  -> why? Method OverRiding을 하면 Animal Class에 있는 breath가 overriding 되어 있는 fish 에 있는 breath를 호출한다!
		//	=> Overriding 된 자원에 한해서만 down-casting을 하지 않아도 하단부에 있는 (자식영역에 있는) data에 접근 가능하다!	
		
	}
}
