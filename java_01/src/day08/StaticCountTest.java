package day08;

public class StaticCountTest {

	public static void main(String[] args) {
		
		StaticCount sc1 = new StaticCount();
		System.out.println("sc1의 c : " +sc1.c + ", sc1의 count : " +sc1.count );
		
		
		StaticCount sc2 = new StaticCount();
		System.out.println("sc2의 c : " +sc2.c + ", sc2의 count : " +sc2.count );
		
		
		StaticCount sc3 = new StaticCount();
		System.out.println("sc3의 c : " +sc3.c + ", sc3의 count : " +sc3.count );

		
		StaticCount sc4 = new StaticCount();
		System.out.printf("sc4의 c : %s, sc4의 count : %s%n",sc4.c, sc4.count);
	}
}
	// [ 정리 ]
	// StaticCountTest를 통해 instance 자원 c는 호출될 때마다 증가한 값이 출력되지 않았지만,
	// static한 자원 count는 Heap영역에 memory를 띄워서 사용하기 때문에
	// StaticCount() method 내에 count++; 로 증가 되었고, 호출 될 때마다 증가 되어서
	// 증가된 값이 출력되는 것을 알 수 있음