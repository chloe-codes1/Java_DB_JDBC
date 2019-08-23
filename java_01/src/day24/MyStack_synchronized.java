package day24;

import java.util.Arrays;

public class MyStack_synchronized {

	int size;
	int[] Stack = {};
	int count = 0;
	// 배열의 크기는 얼마만큼이지만, 실질적으로 몇개가 들어있는지 알려고 count 변수를 둠
	// -> count가 0이면 stack이 비어있는 것!

	// 생성자
	public MyStack_synchronized() {
		Stack = new int[10];
	}

	public MyStack_synchronized(int size) {
		if (size < 0) {
			Stack = new int[10];
		} else {
			Stack = new int[size];
			this.size = size;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(Stack);
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyStack_synchronized other = (MyStack_synchronized) obj;
		if (!Arrays.equals(Stack, other.Stack))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	// => Producer 역할 -> synchronize 해야 동기화 문제 막을 수 있음!
	public synchronized void push(int i) {

		// 가득 차면 못 넣으니까 조건식 추가함
		if (isFull()) {
			try {
				// [ wait 넣어서 DeadLock 회피 ]
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int[] copy = new int[Stack.length * 2];
			System.arraycopy(Stack, 0, copy, 0, Stack.length);
			Stack = copy;

		}
		Stack[count] = i;
		count++;

		System.out.println("Push => " + i);

		notifyAll();
	}

	// => Consumer 역할 -> synchronize 해야 동기화 문제 막을 수 있음!
	public synchronized int pop() {

		if (isEmpty()) {
			try {
		// [ wait 넣어서 DeadLock 회피 ]
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		int data = Stack[--count];
		System.out.println("             pop => " + data);
		notifyAll();

		return data;
	}

	public synchronized int top() {
		if (isEmpty())
			return -1;

		return Stack[count - 1];

	}

	public boolean isFull() {

		// ver1) 내가 처음에 푼것
//			boolean flag = false;
//			if (Stack.length >= size - 1) {
//				flag = true;
//			}
//			return flag;

		// ver2) 삼항연산자 사용
		return count == Stack.length ? true : false;

	}

	public boolean isEmpty() {

		// ver1) 요건 내가 처음에 푼것..
//			boolean flag = false;
//			for (int i = 0; i < Stack.length; i++) {
		//
//				if (Stack[i] == 0) {
//					flag = true;
//				}
//			}
//			return flag;

		// ver2) 삼항 연산자 사용하여 stack이 비어있는지 확인
		return count == 0 ? true : false;

	}
}
