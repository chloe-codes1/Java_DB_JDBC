package day14.tv;


interface TV {
	//TV들간의 호환을 위해 public class TV를 interface TV로 바꿈!
	
	public void powerOn();
	public void powerOff();
	//interface TV에 위의 abstract method들을 만듬으로써 다른 TV회사들이 같은 기능을 override 하도록 약속을 정한거임!
}


class Stv implements TV{
	
	@Override
	public void powerOn() {
		System.out.println("Stv power on");
	}
	@Override
	public void powerOff() {
		System.out.println("Stv power off");
	}
}


class Ltv implements TV{

	@Override
	public void powerOn() {
		System.out.println("Ltv power on");
	}
	@Override
	public void powerOff() {
		System.out.println("Ltv power off");
	}
}


class Itv {
	
	
}
