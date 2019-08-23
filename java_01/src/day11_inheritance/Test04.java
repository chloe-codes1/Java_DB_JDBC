package day11_inheritance;

public class Test04 {

	public static void main(String[] args) {

		String msg1 = "hello";
		String msg2 = "hello";
		System.out.println(msg1.toString()); 
		System.out.println(msg2); //msg2.toString으로 auto converting이 됨 
		 //=> String class는 이미 부모인 Object로부터 물려받은 toString() method가 이미 Override 되어있다
		
		Book b1 = new Book("Java", 10000);
		Book b2 = new Book("Java", 10000);
		System.out.println(b1.toString()); //toString 해도 주소 찍힘
		System.out.println(b2);
		  //=> b1,b2 모두 주소를 출력함
		  //   -> toString() method를 overriding해서 해결했음!
	}
}

class Book extends Object{
		//모든 객체는 Object을 extends한다!
		// -> Object는 모든 객체의 부모다!
	String title;
	int price;
	
	
	public Book() {}
	
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	// Object의 toString() method를 Book class에서 Override 하자 Book 객체 제대로 출력됨
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(title);
		sb.append(" : ");
		sb.append(price);
		sb.append("]");
		return sb.toString();
	}
}
