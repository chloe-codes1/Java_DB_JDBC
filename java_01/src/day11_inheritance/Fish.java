package day11_inheritance;

import day10.Animal;
//import 하면 다른 package에 있는 public class 쓸 수 있다!

public class Fish extends Animal {

	//private처리 하여 encapsulation함
	private String name;

	//super()가 부모의 default 생성자를 호출하므로, Animal Class에 기본 생성자 없으면 오류난다!
	public Fish() {
		super("물고기");
		//-> Fish를 이름 없이 호출해도 물고기는 뜨게 했음
		
	}
	public Fish(String name) {
		super("물고기");
		//Animal class의 kind인 동물의 종류 대신 물고기가 출력되게 하는 코드
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
// [ Method Overriding ]
	//: 부모로부터 물려 받은 기능을 다시 재정의 하는 것!
	//-> 방법: 부모영역에 있는 해당 method 선언부를 그대로 가져오면 됨!
	
	@Override
	//[ @Override Annotation ] : 오버라이딩이 제대로 되었는지 확인해줌!
	//-> override 했다고 생각했지만 만약 오타나서 안되었을 때 잡아줄 수 있음
	//-> annotation은 컴파일 시에도 사라지지 않는 주석이다!
	
	public void breath() {
	//Animal Class의 breath() method 선언부 그대로 가져옴
		System.out.printf("%s : 아가미로 숨쉰다~~!%n", kind);
	}
	
	public void fishPrint() {
		System.out.printf("[%s : %s]%n",super.kind, this.name);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf(" : %s ]%n", this.name);
		
		//Fish class 안에 kind 없으므로 this.kind 불가, super.kind 가능!  => (하지만 나중에 super.print() method로 대체함...)
		//Fish class 안에 name 있지만, Animal class엔 없으므로 this.name 가능, super.name 불가!
		
	//this.fishPrint(); //위에 super.print()랑 System.out 대신에 이렇게 해도 됨! (같은 내용이니까~)
		// -> Overriding을 통해 부모가 접근할 수 없는 자식 영역에 있는 data를 handling 할 수 있다!
	}
}
