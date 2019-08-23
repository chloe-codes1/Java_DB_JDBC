package day05;

public class Test05 {

	public static void main(String[] args) {

		// [ 이차원 배열 ]
		// = 일차원 배열의 주소가 모아져있는것
		// = 이차원 배열은 일차원 배열이 가리키는 자료의 주소를 보관한다
		// -> 이차원주소가 항상 정방형은 아님~!

		// [][] -> 이차원 배열 => 3행 2열 배열의 방을 넣음
		int[][] t1 = new int[3][2];

		// 이차원 배열의 방을 채워넣기
		t1[0][0] = 1;
		t1[0][1] = 2;
		t1[1][0] = 3;
		t1[1][1] = 4;
		t1[2][0] = 5;
		t1[2][1] = 6;

		System.out.println(t1[0][0] + " , " + t1[0][1]);
		System.out.println(t1[1][0] + " , " + t1[1][1]);
		System.out.println(t1[2][0] + " , " + t1[2][1]);

		System.out.println("----------------------");

		// 2차원 배열의 생성과 선언, 초기화를 한번에 하기
		int[][] t2 = { { 1, 2 }, { 3, 4 }, { 5, 6 }

		};

		System.out.println(t2[0][0] + " , " + t1[0][1]);
		System.out.println(t2[1][0] + " , " + t1[1][1]);
		System.out.println(t2[2][0] + " , " + t1[2][1]);
	}

}
