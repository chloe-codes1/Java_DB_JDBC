package day10;

public class AnimialTest01 {

	public static void main(String[] args) {

		//default로 생성
		Animal a1 = new Animal();
		a1.breath(); //"동물의 종류 : 폐로 숨쉰다~~"  -> kind에 입력된 값 없어서 default값인 동물의 종류라고 출력됨
	
		Animal a2 = new Animal("Dog");
		a2.breath();
		
		Dog d1 = new Dog();
		d1.breath();
		//세팅을 안해놔서 "동물의 종류 : 폐로 숨쉰다~! 출력됨"
		
		d1.dogPrint();
		
		Dog d2 = new Dog("시베리안허스키", "케리");
		d2.dogPrint();
		
		Dog d3 = new Dog("Dog", "진돗개", "쫑이");
		d3.dogPrint();
		
		
		//static영역에서는 this keyword, super keyword 쓸수 없음!!!!!!!!!!
		//this랑 super는 heap영역에서만 사용 가능하다!!!!!!!!
		
		String animalKind = d3.getSuperKind();
		System.out.println(animalKind);
		
	}

}
