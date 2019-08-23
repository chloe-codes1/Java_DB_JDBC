package day19_Map;

public class Node<E> {

	//LinkedList는 Node 기반이다.
	// -> Node 기반이란?
	
	// [ Node 기반 ]
	//	: 나는 이런 데이터고, 다음 데이터는 ~~~에 있어 
	
	//데이터 타입 아직 몰라서 Generic으로 생성
	E data;
	// -> 나는 이런 데이터고
	Node<E> next;
	// -> 다음 데이터의 위치를 가리킴
	
	
	
	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}
