package day12;

	// [ abstract class]
	// : 상속을 전제로 만들어진 class
public abstract class Animal {


	protected String kind = "동물의 종류";

	public Animal() {
		super();
	}
	
	public Animal(String kind) {
		super();
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	// [ abstract method ] 
	public abstract void breath();
	
	public void print() {
		System.out.printf("[ Animal Kind : %s",kind);
		
	}
}
