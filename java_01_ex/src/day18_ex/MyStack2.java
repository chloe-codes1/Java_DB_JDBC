package day18_ex;

public class MyStack2<E> {
	
	//Generic 사용하기
	
	E[] stack;
	int top = 0;
	int size;
	
	public MyStack2() {
		stack = (E[])new Object[10];
	}

	public MyStack2(int size) {
		if(size<0) {
			stack = (E[]) new Object[10];
		}
		else {
			stack = (E[]) new Object[size];
			this.size = size;
		}
	}
	
	
	public void push(E i) {

		//가득 차면 못 넣으니까 조건식 추가함
		if(isFull()) {
			
		//ver1) 가득 차서 넣을 곳 없다
//			System.out.println("Stack is full");
//			return;
		
		//ver2) 배열 늘리기도 가능	
		E[]copy = (E[]) new Object[stack.length*2];
		System.arraycopy(stack, 0, copy, 0, stack.length);
		stack = copy;
			
		}
		stack[top] = i;
		top++;
	}
	
	
	public int pop() {
		int out = -1;

		if (top != 0) {
			out = (int) stack[top - 1];

			top--;
		}
		return out;
	}

	public int top() {
		if(isEmpty()) return -1;

		return (int) stack[top - 1];

	}

	public boolean isFull() {
		
		//ver1) 내가 처음에 푼것
//		boolean flag = false;
//		if (Stack.length >= size - 1) {
//			flag = true;
//		}
//		return flag;
		
		//ver2) 삼항연산자 사용
		return top == stack.length ? true: false;
		
	}

	public boolean isEmpty() {

		return top == 0 ? true:false;
	}
}
