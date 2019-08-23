package day12;

public class Dog extends Animal{
	// Animal class는 abstract class라서 abstract method를 override 하지 않으면 에러 뜸!!!
	// -> 구현해야 할 method를 구현하지 않아서 에러가 뜨는거다~
	
	//에러 뜬 Dog에 마우스 올리면 'add unimplemented methods 누르면 자동으로 override 해줌
	
	
	String kind;
	String name;
	
	
	public Dog() {
		super("강아지");
	}


	public Dog(String kind, String name) {
		super("강아지");
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

	
	//부모 method Animal이 갖고있는 abstract method를 Override함
	@Override
	public void breath() {
		System.out.printf("%s: 폐로 숨쉬기~!%n",super.kind);
	}

	//source - generate toString으로 만들 수 있음!
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Dog [kind=");
		sb.append(kind);
		sb.append(", name=");
		sb.append(name);
		sb.append("]");
		
		return sb.toString();
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
	
		return true;
	} 
	 
	
}
