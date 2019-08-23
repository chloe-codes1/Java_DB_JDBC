package day24;

public class Test02_MyStackTest {
	// push 작업을 하는 thread, pop 작업을 하는 thread 만들기
	public static void main(String[] args) {

		System.out.println("*** main start ***");
		
		MyStack_synchronized stack = new MyStack_synchronized();
		
		//같은 stack을 가리키고 있음
		PushJob job1 = new PushJob(stack);
		PopJob job2 = new PopJob(stack);
		
		Thread push = new Thread(job1, "Push");
		Thread pop = new Thread(job2, "Pop");
		
		//실행 대기 큐에 집어넣기
		push.start();
		pop.start();
		
		try {
			push.join();
			pop.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("*** main end ***");
		
	}

}

class PushJob implements Runnable {

	MyStack_synchronized stack;

	public PushJob() {
	}

	public PushJob(MyStack_synchronized stack) {
		this.stack = stack;
	}

	@Override
	public void run() {
		//10번 넣기
		for (int i = 0; i < 10; i++) {
			stack.push(i);

			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PopJob implements Runnable {
	
	MyStack_synchronized stack;
	
	public PopJob() {}
	
	public PopJob(MyStack_synchronized stack) {
		super();
		this.stack = stack;
	}


	@Override
	public void run() {
		//10번 꺼내기
		for(int i = 0; i<10 ; i++) {
			stack.pop();
		
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}