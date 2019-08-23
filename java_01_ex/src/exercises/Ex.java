package exercises;

class Parent {
	int x=100;
	Parent() {
		this(200);
		System.out.println("Parent class 기본생성자");
	}
	Parent(int x) {
		this.x = x;
		System.out.println("Parent class parameter 1 생성자");
	}
	int getX() {
		return x;
	}
}
class Child extends Parent {
	int x = 3000;
	Child() {
		this(1000);
		System.out.println("child class 기본생성자");
	}
	Child(int x) {
		this.x = x;
		System.out.println("child class parameter 1 생성자");
	}
}


public class Ex {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("x="+c.getX());
	}
}