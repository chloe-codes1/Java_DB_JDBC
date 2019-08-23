package day23;

public class Test08_Thread {

	public static void main(String[] args) {

		// [ Thread ]

		// Thread의 우선순위 어떻게 되는지 확인해보기
		// ex) Garbage Collector의 우선순위는 1임!
		// -> 꽉차면 다른일 재쳐두고 GC돌릴 수 있도록 우선순위 1임
//		System.out.println(Thread.MAX_PRIORITY); //10
//		System.out.println(Thread.MIN_PRIORITY); //1
//		System.out.println(Thread.NORM_PRIORITY); //5

		System.out.println("*** Main Start ***");

		
		// [ .sleep() ]
		// : 무조건 양보
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		// -> main start 찍고 main은 5초동안 잠잤음 
		
		// [ .yield ]
		// : 조건적 양보
		Thread.yield(); //실행 대기 큐에 기다리는 애가 없으므로 무시!
		
		System.out.println(Thread.currentThread());
		// -> 현재 점유하고 있는 Thread 결과
		// = Thread[main,5,main]
		// -> main도 Thread다!

		// 가상의 CPU (Thread) 위에 얹어질 Runnable을 implements하는 Job1,2 만들기 ->class 2개 만들었음!

		// [ Thread 생성 ]
		Job1 job1 = new Job1();
		Thread t1 = new Thread(job1, "job1");   //-> Thread이름 "job1"로 설정해주기
		   // -> 가상의 cpu Thread t1에 Job1을 얹음!
		   // -> 그래서 t1은 홀수의 합을 구하는 역할 할 것임
		
		Job2 job2 = new Job2();
		Thread t2 = new Thread(job2);
		
		//[ .start() ]
		
		//실행 대기 큐에 넣어주기   -> 그래야 일을 함
		t1.start();
		
		t2.start();
		
		
		//재우기
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		
		// [ .join() ]
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// -> t1과 t2가 완전히 수행 될 때까지 나머지는 모두 blocked
		// -> 이 둘이 끝날 때까지 밑에 있는 다른 method들은 수행 불가!
		
		
		//t1의 sum + t2의 sum 구하기
		// -> 0찍음  -> 얘가 먼저 실행되서 이런 것!
		System.out.printf("홀수합 + 짝수합 = %s%n",(job1.sum+job2.sum));
		
		
		//결과
		// : Job1 (t1), Job2 (t2)가 번갈아가면서 CPU를 점유함
		//   -> 교대순서는 실행시킬 때마다 달라짐 (CPU 마음이에오~)
		
		
		System.out.println("*** Main End ***");
	}

}

class Job1 implements Runnable {

	// 홀수의 합을 계산하는 Job1 만들기

	int sum = 0;

	@Override
	public void run() {

		for (int i = 1; i < 100; i = i + 2) {
			sum += i;
			System.out.print(Thread.currentThread()); 
			System.out.printf("1~%s 홀수 합 %s%n", i, sum);
			
//			try {
//				Thread.sleep(5);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			Thread.yield();
		}
	}

}
class Job2 implements Runnable{

	// 짝수의 합을 계산하는 Job2 만들기
	
	int sum = 0;
	
	@Override
	public void run() {
		
		for (int i =0 ; i<100 ; i=i+2) {
			sum += i;
			System.out.printf("0~%s 짝수 합 %s%n", i, sum);
			
//			try {
//				Thread.sleep(5);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			Thread.yield();
		}
	}
	
	
	
}
