package day19_Map;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test01_Stack {

	public static void main(String[] args) {

		// [ java.util.Stack ]
		// -> Stack은 Vector를 extends하는 class다
		Stack<String> stack = new Stack<String>();
		for(int i=0 ; i<100 ; i++) {
			
			stack.push(""+i);
				// i는 String이 아니라서 ""+ 연산으로 바꿔서 넣음
		}
		//맨 마지막에 들어간 것 나오게 하기 -> 99 출력됨
		System.out.println(stack.pop());
	
		// [ java.util.Queue ] 
		//  -> Queue는 Collection을  extends하는 interface다
		Queue<Integer> queue = new LinkedList<Integer>();
									//Queue의 자식인 LinkedList
	
		for(int i = 0; i<100 ; i++) {
			//Queue에서는 push가 아니라 offer() method 사용
			queue.offer(i);
		}
		//Queue에서는 pop이 아니라 poll() method 사용
		System.out.println(queue.poll());
			// -> Queue는 가장 먼저 들어간게 먼저 나와서 0 출력됨!
	}
}


