package day24;

import java.util.ArrayList;
import java.util.Vector;

public class Test01_synchronized {

	public static void main(String[] args) {

		System.out.println("***** main start *****");
		
		Account account = new Account("2019001", "김주현", 99900);
		
		Job1 j1 = new Job1(account);
		//account에 접근해서 인출이 가능한 j1
		
		Job1 j2 = new Job1(account);
		
		Thread t1 = new Thread(j1,"통장");
		Thread t2 = new Thread(j2,"카드");
		
		//이제 통장 인출 가능하다
		t1.start();
		
		//카드 인출도 가능하다
		t2.start();
		
		
		//join() method
		// -> t1과 t2가 모두 수행 될 때까지 모두 block 된다!
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("***** main end *****");
	}

}

class Job1 implements Runnable{
 //-> 인출용
	Account ac;
	
	public Job1() {}
	
	public Job1(Account ac) {
		this.ac = ac;
	}


	@Override
	public void run() {
		for(int i = 0 ; i<5 ; i++) {
			//5번 인출하기
			int money = (int)(Math.random()*7+1)*1000; // -> 1000원에서 7000원 사이 출금하게 하기
			ac.withdraw(money);
			
		}
	}
	
	
}



class Account {
	String number;
	String name;
	int money;
	
	Account(){}

	public Account(String number, String name, int money) {
		super();
		this.number = number;
		this.name = name;
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", name=" + name + ", money=" + money + "]";
	}
	

	//인출
	public synchronized void withdraw(int money) {
		System.out.printf("**** 출금 %s원 ****%n",money);
		System.out.println(Thread.currentThread());
		// 잔액보다 출금액이 크면 안되니까 조건문 달았음
		if(this.money>=money) {
			System.out.printf("잔고 : %s원%n",this.money ); // -> 출금 전 잔고
			this.money -= money;
			System.out.printf("출금 완료 : %s원%n",money );
			System.out.printf("잔고 : %s원%n",this.money ); // -> 출금 후 잔고
		}else {
			System.out.println("잔액이 부족합니다.");
		}
		System.out.println("*******************");
		System.out.println();
	}
}