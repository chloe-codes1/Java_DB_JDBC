package day12;

public class BookTest {

	public static void main(String[] args) {

		String msg1 = "hello";
		String msg2 = "hello";
		
		System.out.println(msg1.toString());
		System.out.println(msg2);
		
		
		System.out.println(msg1.equals(msg2)); //true
		
		
		Book b1 = new Book("Java",1000);
		Book b2 = new Book("Java",1000);
		
		System.out.println(b1.toString());
		System.out.println(b2);
		//주소가 출력되서 Book class에 Object의 toString() method를 Override함
		
		//equals함수가 주소를 비교해서 Book class에 Object의 equals() method를 Override함
		System.out.println(b1.equals(b2)); //override 했더니 true로 제대로 출력됨
		
		System.out.println(b1.equals(null));
		System.out.println(b1.equals(msg1));
		
		//다 쓴 자원을 null assign을 해야 Garbage Collection의 대상이 된다
		//null assign 꼭 해줘야 memory 누수 막을 수 있음!!!! 
		//다 쓴 자원 null assign하는건 기본임! 기억해!
//		b1 = null;
//		b2 = null;
		
		//근데 GC가 언제 돌지 모름
		
		// Garbage Collector 강제로 돌려보기
		System.gc();
		
		System.out.println("=============== main end ===============");
		
		
		//그래서 Book class에 따로 자원 반납을 위한 close() method 만들었음
		//null assign전에 꼭 close() method를 써야함!!
		b1.close();
		b2.close();
		
		b1 = null;
		b2 = null;
		
		
		
	}

}

