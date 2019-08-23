package day12;

public class Test01 {

	public static void main(String[] args) {

	Animal[] animals = {
		new Dog ("시베리안허스키", "케리"),
		new Fish ("구피"),
		new Fish ("Fish", "구피")
		};
	
	for(Animal data: animals) {
		
		System.out.println(data.toString());//.toString 생략가능 -> data. 이렇게 주소 찍고 나면 무조건 .toString으로 문장 자체가 자동 converting 된다
		//System.out.println(data.breath()); //breath()의 return type이 Void인데 println으로 해서 오류남	
		data.breath();
	}
	
	
	}

}
