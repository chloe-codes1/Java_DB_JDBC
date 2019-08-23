package day10;

public class Test03 {

	public static void main(String[] args) {

	// [ 시, 분, 초 정보 관리하기 ]	
		
		Time t1 = new Time(13,20,20);
		
	}

}

class Time{
	
	
	//같이 모여져 있을 때에만 의미가 있는 시간정보 -> 클래스가 필요하다! => time class 만듬
	int hour;
	int minute;
	int second;
	
	
	//기본 생성자 만들기 
		//by using "source - generate constructor using Field"
	
	public Time() {
		super();
		//부모의 생성자를 호출한다.
		//지워도 자동으로 들어감! 없어도 자동호출 됨! -> 안보이면 생략되어있는 것임!
		//생략되어 있는 것 = 부모가 있다는 뜻!
		//this() method처럼 first statement에만 허용된다!
		//-> 그래서 this() method가 사용된 생성자에서는 super() 가 없는 것을 알 수 있음
		//super.______ 하면 자식이 아니라 부모영역부터 search 할 수 있다!
	
		
	}
	
	public Time(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}


	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		
		this.second = second;
	}
	
	
	
}