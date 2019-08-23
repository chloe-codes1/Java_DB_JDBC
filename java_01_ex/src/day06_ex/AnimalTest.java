package day06_ex;

import java.util.Arrays;

public class AnimalTest {

	public static void main(String[] args) {
		/*
		 * 문제1 Animal,AnimalTest 제출합니다.
		 * 
		 * 조건1)
		 * 1. 클래스 이름은 Animal로 한다.
		 * 2. 클래스 내부에는 생존여부를 가리는 속성을 가진다.
		 * 3. 나이와 이름 정보를 기억하는 속성을 가진다.
		 * 4. 이름 정보를 바꾸는 기능이 있어야 한다.
		 * 5. 이름 정보를 반환하는 기능이 있어야 한다.
		 * 6. 생존여부를 반환하는 기능이 있어야 한다.
		 * 
		 * 조건2)
		 * 1. 클래스 이름은 AnimalTest라 한다.
		 * 2. AnimalTest클래스에는 main()메서드를 가진다.
		 * 3. [조건1]의  Animal클래스를 이용하여 나이가 3살, 이름이 "큰뿔소"이며 살아있는 객체를 생성하자. 그리고 이름과 생존여부를 출력해보자.
		 * 4. 위의 "큰뿔소" 객체의 이름을 "팽귄"으로 변경한 후 이름과 생존여부를 출력해보자!
		 */

		Animal ani = new Animal(); // 메모리에 올리기

		ani.setLive(true);
		ani.setAge(3);
		// ani.setAge('3');
		// -> 선언부에 int값을 입력하라고 되어있어서 int 외에 다른 값 쓰면 오류가 나지만,
		// -> char type은 int type으로 promotion이 발생하여 입력 가능.
		// -> but, ASCII CODE 3의 값인 51이 출력된다
		
		ani.setName("큰뿔소");

		ani.display();

		System.out.println("===== 동물의 이름 변경 =====");

		ani.setName("펭귄");

		ani.display();
	}
}
