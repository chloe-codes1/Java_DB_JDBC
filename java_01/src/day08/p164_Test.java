package day08;

public class p164_Test {

	public static void main(String[] args) {
		
		Count c1 = new Count(); //객체생성
		System.out.println(Count.count); //count는 static하므로 class name으로 접근 가능
		System.out.println(c1.c); //c는 instance 하므로 memory에 띄워있지 않아서 객체 이름으로 접근 가능
		
		Count c2 = new Count();
		System.out.println(Count.count);
		System.out.println(c2.c);
		
		Count c3 = new Count();
		System.out.println(Count.count);
		System.out.println(c3.c);
		
		Count c4 = new Count();
		System.out.println(Count.count);
		System.out.println(c4.c);
		
		System.out.println("------ count 증가 확인 -------");
		
		System.out.println(c1.count); 
		System.out.println(c2.count);
		System.out.println(c3.count);
		System.out.println(c4.count);
		//Count class 안에 있는 static한 count는 공유하고 있으므로 class명으로도 접근 가능
			//-> 그래서 아래와 같이 표현함.
		System.out.println(Count.count); 
			
		//결과: static한 count는 증가하였지만, instance한 c는 증가하지 않고 계속 1인것을 알 수 있음!
	}
}

//새로운 class를 하나 더 만듦
	//하나의 java file 안에 public한 class는 하나여야 한다!
		//-> public class를 하나 이상 쓰려면 file을 새로 만들면 됨!
		// + public한 class는 file명이 된다!

class Count{

	int c;
	static int count;
	public Count() {
		System.out.println("[ static count Test]");
		c++;
		count++;
	}
}