package day18_ex;

import java.util.Arrays;

public class StackTest2 {

	//Generic 사용 했을 때
	
	public static void main(String[] args) {
		MyStack2<Integer> stack = new MyStack2<Integer>(10);
		
		//if조건문에 쓰였다는건, isEmpty()의 return type이 boolean인것을 알 수 있음
		if (stack.isEmpty()) {
			System.out.println("스택이 비어있습니다.");
		}

		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}

		if (stack.isFull()) {
			System.out.println("스택이 가득 찼습니다.");
		}

		System.out.println("최상위 숫자 : " + stack.top());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("");
		System.out.println("== 스택 리스트 ==");
		for (int i = 1; i <= 10; i++) {

			int num = stack.pop();
			if (num != -1)
				System.out.println(num);
		}
	}
}