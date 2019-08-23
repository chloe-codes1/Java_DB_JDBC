package day23;

public class Test09_Thread2 {

	public static void main(String[] args) {

		// [ Thread ]

		// Test08 (두 조각짜리 Thread) 에서 한 조각짜리 Thread로 바꾸기 
		

		System.out.println("*** Main Start ***");

		System.out.println(Thread.currentThread());

		// [ Thread 생성 ]
		T1 t1 = new T1();   
		
		T2 t2 = new T2();
		
		//[ .start() ]
		
		//실행 대기 큐에 넣어주기   -> 그래야 일을 함
		t1.start();
		t2.start();
		
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//t1의 sum + t2의 sum 구하기
		// -> 0찍음  -> 얘가 먼저 실행되서 이런 것!
		System.out.printf("홀수합 + 짝수합 = %s%n",(t1.sum+t2.sum));
		
		
		
		System.out.println("*** Main End ***");
	}

}

class T1 extends Thread {

	// 홀수의 합을 계산하는 T1 만들기
	// -> Thread이면서 Job의 역할 
	// -> 한 조각 짜리 Thread

	int sum = 0;

	@Override
	public void run() {

		for (int i = 1; i < 100; i = i + 2) {
			sum += i;
			System.out.print(Thread.currentThread()); 
			System.out.printf("1~%s 홀수 합 %s%n", i, sum);
		}
	}

}
class T2 extends Thread{

	// 짝수의 합을 계산하는 T1 만들기
	// -> Thread이면서 Job의 역할 
	// -> 한 조각 짜리 Thread
	
	int sum = 0;
	
	@Override
	public void run() {
		
		for (int i =0 ; i<100 ; i=i+2) {
			sum += i;
			System.out.printf("0~%s 짝수 합 %s%n", i, sum);
			
		}
	}
}
