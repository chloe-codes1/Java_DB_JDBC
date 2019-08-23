package day07;

import java.util.Arrays;

public class book_p141 {
	
	//[ Call by Reference ]
		// 주소를 넘겨주는 reference type이므로 주소가 가리키는 data가 증가하면 결과값도 같이 증가한다
	
	public void increase(int[] num) { //instance method -> 호출 시 주소 필요
		
		for(int i=0 ; i<num.length ; i++) {
			num[i]++;
		}
}
	
	public static void main(String[] args) {
		
		int[] data = {10, 100, 1000}; //int type 배열 생성
		System.out.println(Arrays.toString(data));
		
		book_p141 p = new book_p141(); //객체생성
		
		System.out.println();
		p.increase(data); //
		// increase method를 주소로 호출하면서 data라는 인자를 전달 -> member method니까
			// 값이아니라 주소를 넘겨주는 것임
			// 주소를 넘겨줬기 때문에 위에서 값이 1이 증가한게 여기서도 증가함
			// 그래서 밑에 찍어봤더니 1 증가 했음
		System.out.println(Arrays.toString(data)); // 갔다왔더니 data가 바뀌어있음
	}
}
