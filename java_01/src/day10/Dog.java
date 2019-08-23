package day10;

//Dog를 Animal과 다른 package로 옮기면 Animal class를 import 해야함!

public class Dog extends Animal{

	//extends = 상속받는다
	
	private String kind = "강아지 종류";
	private String name = "강아지 이름";
	
	//기본 생성자
	public Dog() {
		//super(); => 부모의 기본 생성자를 호출한다!
			//->Animal Class의 기본 생성자를 호출하는데,
			//  String kind = "동물의 종류"가 들어가있으므로 super();를 하면 "동물의 종류"를 호출한다!
		super("강아지과");
		//-> 지워도 자동으로 들어가서 지움!
		
		//현재 Animal Class에 기본생성자를 주석처리해서 에러가 나므로, 아래를 써서 parameter가 한개인 생성자 소환되게 할 수 있음
		//super("Dog"); 
	}
	
	public Dog(String kind, String name) {
		super("강아지과");
		this.kind = kind;
		this.name = name;
	}
	
	public Dog(String superkind, String kind, String name ) {
		
		super(superkind);
		//super.kind =superkind; 
		//-> 2가지 방법으로 할 수 있음
		this.kind = kind;
		this.name = name;
	}
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void dogPrint() {
		System.out.printf("[%s : %s : %s]%n",super.kind,this.kind, this.name);
	}
	
	
	@Override
	public void print() {
		super.print();
		System.out.printf(" %s : %s ]%n",this.kind, this.name);
											//this는 생략가능
		
		//this.dogPrint(); //-> 이렇게 해도 됨
		// -> Overriding을 통해서 접근할 수 없는 자식 영역에 있는 data를 handling 할 수 있다!
	}
	
	// *** static영역에서는 this keyword, super keyword 쓸 수 없음! ***
	
	//this랑 super는 heap영역에서만 사용 가능하기 때문에 super.kind를 쓸 수 있게 getSuperKind() method를 만들었음
	public String getSuperKind() {
		return super.kind;
	}
}
